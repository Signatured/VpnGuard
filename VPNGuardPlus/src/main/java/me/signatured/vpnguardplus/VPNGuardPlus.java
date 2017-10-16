package me.signatured.vpnguardplus;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import lombok.Getter;
import lombok.Setter;
import me.signatured.vpnguardplus.command.VPNGuardMainCommand;
import me.signatured.vpnguardplus.util.ConfigOptions;
import me.signatured.vpnguardshared.messages.ResponseMessage;
import me.signatured.vpnguardshared.network.NetworkClient;
import me.signatured.vpnguardshared.network.message.NetworkMessage;

@Getter @Setter
public class VPNGuardPlus extends JavaPlugin {
	
	@Getter
	private static VPNGuardPlus instance;
	
	private VPNGuardClient clientManager;
	private Optional<NetworkClient> client;
	private ConfigOptions options;
	
	private Map<UUID, ResponseMessage> responses = new HashMap<>();
	
	@Override
	public void onEnable() {
		instance = this;
		options = new ConfigOptions(this);
		saveDefaultConfig();
		
		Bukkit.getPluginManager().registerEvents(new VPNGuardListener(this), this);
		getCommand("vpnguard").setExecutor(new VPNGuardMainCommand());
		
		startClient();
	}
	
	public static boolean sendClientMessage(NetworkMessage nm) {
		if (getInstance().getClient().isPresent() && getInstance().getClient().get().isConnected()) {
			getInstance().getClient().get().send(nm);
			return true;
		}
		return false;
	}
	
	private void startClient() {
		clientManager = new VPNGuardClient(this);
		clientManager.init();
	}
}
