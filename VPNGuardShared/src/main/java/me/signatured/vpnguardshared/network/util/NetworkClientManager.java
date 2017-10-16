package me.signatured.vpnguardshared.network.util;

import java.io.IOException;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import me.signatured.vpnguardshared.IUtil.Loggable;
import me.signatured.vpnguardshared.network.NetworkClient;

/**
 * Manages an instance of a {@link NetworkClient} to make sure it is always
 * connected.
 *
 * @author NomNuggetNom
 */
public abstract class NetworkClientManager implements Loggable, Runnable {
	
	@Getter(AccessLevel.PROTECTED)
	@Setter(AccessLevel.PROTECTED)
	private NetworkClient client;
	
	public NetworkClientManager() {
		setClient(makeClient());
		
		if (getClient() != null) {
			onCreate(getClient());
			
			try {
				getClient().connect();
				onReconnect(getClient());
			} catch (IOException e) {
				System.err.println("[ClientManager] Failed initial connect, will retry later: " + e.getMessage());
			}
		}
	}
	
	@Override
	public void run() {
		if (!isCreated()) {
			log().info("[ClientManager] Attempting to re-create client...");
			setClient(makeClient());
			
			if (getClient() != null) {
				onCreate(getClient());
				log().info("[ClientManager] Client created.");
			}
			
			return;
		}
		
		if (!isConnected()) {
			log().info("[ClientManager] Attempting to re-connect client...");
			boolean connected = true;
			
			try {
				getClient().connect();
			} catch (Exception e) {
				log().warning("[ClientManager] Couldn't reconnect: " + e.getMessage());
				connected = false;
				
				if (e.getMessage() == null)
					e.printStackTrace();
			} finally {
				if (connected) {
					log().info("[ClientManager] Succesfully re-connected client! Hooray.");
					onReconnect(getClient());
				}
			}
		}
	}
	
	/**
	 * @return The NetworkClient to manage, or null if no client instance could
	 *         be created.
	 */
	protected NetworkClient makeClient() {
		try {
			return new NetworkClient();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * @return Whether or not the client has been created.
	 */
	protected boolean isCreated() {
		return getClient() != null;
	}
	
	/**
	 * @return Whether or not the client is connected.
	 */
	protected boolean isConnected() {
		return isCreated() && getClient().isConnected();
	}
	
	/**
	 * Passes the client instance when the client is first created. This should
	 * only fire once.
	 * 
	 * @param client The client instance that was created.
	 */
	protected abstract void onCreate(NetworkClient client);
	
	/**
	 * Passes the client instance any time the client reconnects.
	 * 
	 * @param client The client instance that reconnected.
	 */
	protected abstract void onReconnect(NetworkClient client);
	
}