package me.signatured.vpnguardhub;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.Future;

import com.google.common.collect.Sets;

import lombok.Getter;
import me.signatured.Database;
import me.signatured.vpnguardhub.command.HubCommand;
import me.signatured.vpnguardhub.command.cmds.ListCommand;
import me.signatured.vpnguardhub.command.cmds.LookupCommand;
import me.signatured.vpnguardhub.util.DBUtil;
import me.signatured.vpnguardshared.AddressInfo;
import me.signatured.vpnguardshared.IUtil.Loggable;
import me.signatured.vpnguardshared.IUtil.Syncable;
import me.signatured.vpnguardshared.IUtil.Threadable;
import me.signatured.vpnguardshared.SafeRunnable;
import me.signatured.vpnguardshared.messages.RequestMessage;
import me.signatured.vpnguardshared.messages.ResponseMessage;
import me.signatured.vpnguardshared.network.NetworkClient;
import me.signatured.vpnguardshared.network.NetworkConstants;
import me.signatured.vpnguardshared.network.message.NetworkMessage;
import me.signatured.vpnguardshared.network.util.json.JsonIO;

@Getter
public class VPNGuardHub implements Threadable, Syncable, Loggable {
	
	@Getter
	private static VPNGuardHub instance;
	
	private ServerSocket socket;
	private Set<NetworkClient> connected = Sets.newConcurrentHashSet();
	private DBUtil dbUtil = new DBUtil();
	
	private boolean ready;
	
	public static void main(String[] args) {
		try {
			System.out.println("Starting VPNGuardPlusHub...");
			
			System.out.println("Connecting to database...");
			Database.get();
			System.out.println("Connected to database!");
			
			registerCommands();
			
			instance = new VPNGuardHub(NetworkConstants.PORT);
			instance.init();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Register all hub commands
	 */
	private static void registerCommands() {
		new ListCommand().register();
		new LookupCommand().register();
	}
	
	/**
	 * Creates a new HubServer instance.
	 * 
	 * @param port The port to start the ServerSocket on.
	 */
	public VPNGuardHub(int port) throws IOException {
		socket = new ServerSocket(port);
	}
	
	/**
	 * Begins the thread that will wait for incoming connections
	 */
	public void init() {
		log("Listening for connections and commands...");
		
		thread(() -> {
			while (true) {
				ready = true;
				try {
					Socket incoming = socket.accept();
					
					NetworkClient client = new NetworkClient(incoming);
					
					connected.add(client);
					client.setConnected(true);
					
					// Break off each connection into it's own thread.
					thread(() -> connect(client));
				} catch (Exception e) {
					if (e.getMessage() != null && e.getMessage().equals("Socket is closed"))
						break;
					e.printStackTrace();
				}
			}
		});
		
		thread(() -> {
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			
			while (true) {
				String command = input.nextLine();
				if (command.isEmpty())
					continue;
				
				String[] parts = command.split(" ");
				HubCommand cmd = HubCommand.getCommand(parts[0]);
				if (cmd == null)
					continue;
				
				if (parts.length == 1)
					cmd.execute(parts[0], new String[0]);
				else
					cmd.execute(parts[0], Arrays.copyOfRange(parts, 1, parts.length));
			}
		});
	}
	
	/**
	 * Begins waiting for input from the given client.
	 * 
	 * @param incoming The client that connected and will be sending input.
	 */
	protected void connect(NetworkClient incoming) throws IOException {
		log("Connected: " + incoming);
		
		// Basic listening for later.
//		incoming.init();
		
		while (true) {
			try {
				String str = incoming.getIn().readLine();
				
				if (str != null) {
					thread(() -> {
						// Safety catch for input handling.
						attempt(() -> handle(incoming, str));
					});
				} else
					break;
			} catch (Exception e) {
				if (!e.getMessage().equals("Socket closed") && !e.getMessage().equals("Connection reset"))
					e.printStackTrace();
				break;
			}
		}
		
		log("Disconnected: " + incoming);
		connected.remove(incoming);
		incoming.getSocket().close();
		incoming.getExecutor().shutdownNow();
		Thread.currentThread().interrupt();
	}
	
	public void handle(NetworkClient client, String input) {
		NetworkMessage msg = NetworkMessage.from(input);
		if (msg == null) {
			log("Failed to deserialize: " + input);
			return;
		}
		
		try {
			RequestMessage request = JsonIO.load(msg.getData(), RequestMessage.class);
			if (request == null)
				return;
			AddressInfo info = dbUtil.getCachedInfo(request.getIp(), request.getPlayerName(), request.getUuid());
			
			if (info == null)
				info = XioaxAPI.getAddressInfo(request.getIp());
			
			if (info == null)
				return;
			
			dbUtil.insertIp(info, request.getPlayerName(), request.getUuid());
			
			ResponseMessage response;
			if (request.isCommand())
				response = ResponseMessage.builder().command(true).commandSender(request.getCommandSender()).ip(request.getIp()).info(info).build();
			else
				response = ResponseMessage.builder().playerName(request.getPlayerName()).uuid(request.getUuid()).ip(request.getIp()).info(info).build();
			
			client.send(NetworkMessage.of(response));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param hm The message to send.
	 * @param client The client to send the message to.
	 */
	public Future<NetworkMessage> send(NetworkMessage hm, NetworkClient client) {
		return client.send(hm);
	}
	
	private void attempt(SafeRunnable sr) {
		try {
			sr.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
