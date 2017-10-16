package me.signatured.vpnguardplus;

import org.bukkit.entity.Player;

import me.signatured.vpnguardshared.messages.RequestMessage;
import me.signatured.vpnguardshared.network.message.NetworkMessage;

public class VPNGuardAPI {
	
	public static void sendRequest(Player player) {
		RequestMessage rm = RequestMessage.builder().playerName(player.getName()).uuid(player.getUniqueId().toString())
				.ip(player.getAddress().getHostName()).build();
		VPNGuardPlus.sendClientMessage(NetworkMessage.of(rm));
	}
	
	public static void sendRequest(String playerName, String uuid, String ip) {
		RequestMessage rm = RequestMessage.builder().playerName(playerName).uuid(uuid).ip(ip).build();
		VPNGuardPlus.sendClientMessage(NetworkMessage.of(rm));
	}
	
	public static void sendCommandRequest(String sender, String ip) {
		RequestMessage rm = RequestMessage.builder().command(true).commandSender(sender).ip(ip).build();
		VPNGuardPlus.sendClientMessage(NetworkMessage.of(rm));
	}
}
