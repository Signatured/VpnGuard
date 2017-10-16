package me.signatured.vpnguardplus.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import me.signatured.vpnguardplus.util.ConfigOptions;

public interface IVPNGuardCommand {
	
	ConfigOptions options();
	String prefix();
	String getFullUsage();

	void run(CommandSender sender, String commandLabel, Command cmd, String[] args);
	void run(CommandSender sender, String[] args);
	void sendFullUsage(CommandSender sender);
}
