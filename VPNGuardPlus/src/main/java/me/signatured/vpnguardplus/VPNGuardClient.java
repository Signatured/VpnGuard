package me.signatured.vpnguardplus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import me.signatured.vpnguardplus.util.ConfigOptions;
import me.signatured.vpnguardplus.util.Util;
import me.signatured.vpnguardshared.AddressInfo;
import me.signatured.vpnguardshared.messages.ResponseMessage;
import me.signatured.vpnguardshared.network.NetworkClient;
import me.signatured.vpnguardshared.network.util.NetworkClientManager;

public class VPNGuardClient extends NetworkClientManager {
	
	private VPNGuardPlus plugin;
	private ConfigOptions options;
	
	public VPNGuardClient(VPNGuardPlus plugin)  {
		this.plugin = plugin;
		this.options = plugin.getOptions();
	}
	
	public VPNGuardClient init() {
		Bukkit.getScheduler().runTaskTimerAsynchronously(VPNGuardPlus.getInstance(), this, 20, 10);
		return this;
	}

	@Override
	protected void onCreate(NetworkClient client) {
		client.setConsumer((rm) -> {
			Bukkit.getScheduler().runTask(VPNGuardPlus.getInstance(), () -> {
				if (rm.isCommand())
					handleCommandReturn(rm);
				else
					handleResponse(rm);
			});
		});
	}
	
	private void handleCommandReturn(ResponseMessage rm) {
		List<String> info = getCommandInfo(rm);
		
		if (rm.getCommandSender().equalsIgnoreCase("Console Sender"))
			info.forEach(s -> Bukkit.getConsoleSender().sendMessage(options.getPrefix() + s));
		else {
			Player player = Bukkit.getPlayer(rm.getCommandSender());
			
			if (player == null)
				return;
			
			info.forEach(s -> player.sendMessage(s));
		}
	}
	
	private void handleResponse(ResponseMessage rm) {
		plugin.getResponses().put(UUID.fromString(rm.getUuid()), rm);
	}
	
	private List<String> getCommandInfo(ResponseMessage rm) {
		List<String> list = new ArrayList<>();
		AddressInfo info = rm.getInfo();
		String v = Util.VERTICAL_LINE + ChatColor.AQUA;
		
		list.add("");
		list.add(v + "IP: " + ChatColor.YELLOW + rm.getIp());
		list.add(v + "Host: " + ChatColor.YELLOW + info.isHost());
		list.add(v + "Organization: " + ChatColor.YELLOW + info.getOrg());
		list.add(v + "Country: " + ChatColor.YELLOW + info.getCountry());
		list.add(v + "Subdivision: " + ChatColor.YELLOW + info.getSubdivision());
		list.add(Util.HORIZONTAL_LINE);
		
		return list;
	}

	@Override
	protected void onReconnect(NetworkClient client) {
		client.setConnected(true);
		client.listen();
	}
	
	@Override
	protected NetworkClient getClient() {
		return VPNGuardPlus.getInstance().getClient().orElse(null);
	}
	
	@Override
	protected void setClient(NetworkClient client) {
		VPNGuardPlus.getInstance().setClient(Optional.ofNullable(client));
	}

}
