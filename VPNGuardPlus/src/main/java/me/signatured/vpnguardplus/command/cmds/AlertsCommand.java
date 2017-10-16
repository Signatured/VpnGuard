package me.signatured.vpnguardplus.command.cmds;

import org.bukkit.command.CommandSender;

import me.signatured.vpnguardplus.command.VPNGuardCommand;
import me.signatured.vpnguardplus.util.Status;

public class AlertsCommand extends VPNGuardCommand {

	public AlertsCommand() {
		super("alerts", "alert");
		setPermission("vpnguardplus.alerts");
		setDescription("Disable or enable kick alerts");
		setUsage("/vpnguard alerts [on/off]");
	}

	@Override
	public void run(CommandSender sender, String[] args) {
		if (args.length == 0) {
			options().setAlertsEnabled(!options().isAlertsEnabled());
			Status status = Status.getStatus(options().isAlertsEnabled());
			
			sender.sendMessage(prefix() + "Kick alerts have been turned " + status.getColoredName());
			return;
		}
		
		Status status = Status.getStatus(args[0]);
		if (status == null) {
			sender.sendMessage(getFullUsage());
			return;
		}
		
		options().setAlertsEnabled(status.getBoolean());
		sender.sendMessage(prefix() + "Kick alerts have been turned " + status.getColoredName());
	}
}
