package me.signatured.vpnguardplus.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.signatured.vpnguardplus.command.cmds.AlertsCommand;
import me.signatured.vpnguardplus.command.cmds.BanCountryCommand;
import me.signatured.vpnguardplus.command.cmds.LookupCommand;

public class VPNGuardMainCommand implements CommandExecutor {
	
	public VPNGuardMainCommand() {
		new AlertsCommand();
		new BanCountryCommand();
		new LookupCommand();
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!cmd.getName().equalsIgnoreCase("vpnguard"))
			return true;
		
		if (args.length == 0) {
			sendHelp(sender);
			return true;
		}
		
		VPNGuardCommand gc = VPNGuardCommand.getCommand(args[0]);
		if (gc == null) {
			sendHelp(sender);
			return true;
		}
		
		gc.run(sender, label, cmd, args);
		return true;
	}

	private void sendHelp(CommandSender sender) {
		for (VPNGuardCommand gc : VPNGuardCommand.getCommands())
			gc.sendFullUsage(sender);
	}
}
