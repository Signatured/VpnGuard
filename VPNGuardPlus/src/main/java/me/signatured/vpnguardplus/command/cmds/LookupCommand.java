package me.signatured.vpnguardplus.command.cmds;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.signatured.vpnguardplus.VPNGuardAPI;
import me.signatured.vpnguardplus.command.VPNGuardCommand;
import me.signatured.vpnguardplus.util.Util;

public class LookupCommand extends VPNGuardCommand {

	public LookupCommand() {
		super("lookup", "lookupip", "check", "checkip");
		setPermission("vpnguardplus.lookup");
		setDescription("Lookup an ip or player");
		setUsage("/vpnguard lookup <ip/player>");
	}

	@Override
	public void run(CommandSender sender, String[] args) {
		if (args.length == 0) {
			sendFullUsage(sender);
			return;
		}
		
		boolean isIp = Util.isIp(args[0]);
		
		if (!isIp) {
			Player player = Bukkit.getPlayer(args[0]);
			
			if (player == null) {
				sender.sendMessage(prefix() + ChatColor.RED + "Player not found!");
				return;
			}
			
			sender.sendMessage(prefix() + "Sent your lookup request for " + player.getName() + ".");
			VPNGuardAPI.sendCommandRequest(getSenderName(sender), player.getAddress().getHostName());
			return;
		}
		
		sender.sendMessage(prefix() + "Sent your lookup request for " + args[0] + " ip.");
		VPNGuardAPI.sendCommandRequest(getSenderName(sender), args[0]);
	}
	
	private String getSenderName(CommandSender sender) {
		if (isPlayer(sender))
			return asPlayer(sender).getName();
		
		return "Console Sender";
	}

}
