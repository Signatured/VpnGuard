package me.signatured.vpnguardshared.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import com.google.common.collect.Sets;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import me.signatured.vpnguardshared.IUtil.Loggable;
import me.signatured.vpnguardshared.IUtil.Threadable;
import me.signatured.vpnguardshared.messages.ResponseMessage;
import me.signatured.vpnguardshared.network.message.NetworkMessage;
import me.signatured.vpnguardshared.network.util.json.JsonIO;

@Getter
@Setter
@EqualsAndHashCode(of="socket")
public class NetworkClient implements Threadable, Loggable {
	
	/**
	 * All messages sent by any client or hub.
	 */
	static Set<NetworkMessage> sent = Sets.newConcurrentHashSet();
	
	private String host;
	private int port;
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	private ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
	private Consumer<ResponseMessage> consumer;
	private boolean connected = false;
	
	/**
	 * Creates a new NetworkClient instance with the pre-existing Socket.
	 * 
	 * @param socket The Socket that this client is connected to.
	 */
	public NetworkClient(Socket socket) throws IOException {
		this.socket = socket;
		this.host = socket.getInetAddress().getHostAddress();
		this.port = socket.getPort();
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
	}
	
	/**
	 * Creates a new NetworkClient instance, but does not immediately connect it.
	 * 
	 * @param server The address of the remote NetworkHub to connect to.
	 * @param port The port of the remote NetworkHub to connect to.
	 */
	public NetworkClient(String server, int port) {
		this.host = server;
		this.port = port;
	}
	
	/**
	 * Creates a new NetworkClient instance, using the default host and port,
	 * and passes it to {@link NetworkClient#HubClient(String, int)}.
	 */
	public NetworkClient() {
		this(NetworkConstants.HOST, NetworkConstants.PORT);
	}
	
	/**
	 * Creates the socket instance backing this NetworkClient.
	 * 
	 * @throws IOException If something goes wrong creating the client.
	 */
	public void connect() throws IOException {
		socket = new Socket(host, port);
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
		connected = true;
		executor = Executors.newScheduledThreadPool(5);
	}
	
	/**
	 * Begins listening for input.
	 */
	public void listen() {
		thread("NetworkClientInput", () -> {
			while (true) {
				try {
					String str = in.readLine();
					
					if (str == null)
						break;
					
					System.out.println("[CLIENT] Received: " + str);
					try {
						handle(str);
					} catch (Exception e) {
						System.err.println("[Client] Error handling input");
						e.printStackTrace();
					}
				} catch (Exception e) {
					System.out.println("[Client] Disconnected.");
					connected = false;
					break;
				}
			}
			
			connected = false;
			executor.shutdown();
			socket.close();
		});
	}
	
	public void handle(String input) {
		NetworkMessage msg = NetworkMessage.from(input);
		if (msg == null) {
			log("Failed to deserialize: " + input);
			return;
		}
		
		ResponseMessage rm = JsonIO.load(msg.getData(), ResponseMessage.class);
		consumer.accept(rm);
	}
	
	/**
	 * Sends the given message to the receiving client. In most cases, this is
	 * the NetworkHub. But from the HubServer's perspective this method
	 * communicates to a receiving client.
	 * 
	 * @param hm The message to send.
	 * @return A Future that will eventually fulfill to the message given once
	 *         it is sent. Null is returned if sending fails.
	 */
	public Future<NetworkMessage> send(NetworkMessage hm) {
		System.out.println("[CLIENT] Sending: " + hm);
		
		if (!connected)
			return null;
		
		return executor.submit(() -> {
			try {
				// Encode and send the message, then flush the output.
				String encoded = JsonIO.save(hm, false);
				
				out.println(encoded);
				out.flush();
				
				// Now that it's sent...
				if (sent.add(hm))					
					// Remove after reply timeout to avoid memory issues.
					executor.schedule(() -> sent.remove(hm), hm.getReplyTimeout(), TimeUnit.MILLISECONDS);
				
				return hm;
			} catch (Exception e) {
				System.out.println("Error sending message: " + hm);
				e.printStackTrace();
				return null;
			}
		});
	}
}
