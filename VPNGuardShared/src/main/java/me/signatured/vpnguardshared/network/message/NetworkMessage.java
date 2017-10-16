package me.signatured.vpnguardshared.network.message;

import java.util.UUID;

import com.google.common.reflect.TypeToken;

import lombok.Data;
import me.signatured.vpnguardshared.network.util.json.JsonIO;

@Data
public class NetworkMessage {
	
	private final UUID uuid = UUID.randomUUID();
	private final long sent = System.currentTimeMillis();
	private String dataType;
	private String data;
	private transient Class<?> type;
	private long replyTimeout = 30 * 1000;
	
	/**
	 * Creates a new NetworkMessage instance.
	 * 
	 * @param data The packaged data to include in the message.
	 * @return The created message instance.
	 */
	public static <T> NetworkMessage of(T data) {
		return of(data, data == null ? TypeToken.of(Object.class) : TypeToken.of(data.getClass()));
	}
	
	/**
	 * Creates a new NetworkMessage instance.
	 * 
	 * @param data The packaged data to include in the message.
	 * @param type The specific type of data. This is required if the passed
	 *        data is a generic object and needs to be preserved.
	 * @return The created message instance.
	 */
	public static <T> NetworkMessage of(T data, TypeToken<?> type) {
		NetworkMessage nm = new NetworkMessage();
		if (data != null) {
			nm.data = JsonIO.save(data, false);
			nm.dataType = type.toString();
			nm.type = type.getRawType();
		}
		
		return nm;
	}
	
	/**
	 * Deserializes the given String into it's original NetworkMessage form.
	 * 
	 * @param str The string to deserialize.
	 * @return The deserialized instance.
	 */
	public static NetworkMessage from(String str) {
		NetworkMessage nm = JsonIO.load(str, NetworkMessage.class);
		try {
			nm.type = Class.forName(nm.getDataType());
		} catch (Exception e) {}
		return nm;
	}
}
