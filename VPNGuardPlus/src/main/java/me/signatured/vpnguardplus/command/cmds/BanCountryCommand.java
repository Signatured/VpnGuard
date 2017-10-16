package me.signatured.vpnguardplus.command.cmds;

import org.bukkit.command.CommandSender;

import me.signatured.vpnguardplus.command.VPNGuardCommand;
import me.signatured.vpnguardplus.util.Status;

public class BanCountryCommand extends VPNGuardCommand {

	public BanCountryCommand() {
		super("bancountry");
		setPermission("vpnguardplus.bancountry");
		setDescription("Disable or enable country banning or add/remove a country");
		setUsage("/vpnguard bancountry <on/off/add/remove> [country]");
	}

	@Override
	public void run(CommandSender sender, String[] args) {
		if (args.length == 0) {
			sendFullUsage(sender);
			return;
		}
		
		switch (args[0].toLowerCase()) {
		
		case "on":
		case "off":
			Status status = Status.getStatus(args[0]);
			options().setBanCountryEnabled(status.getBoolean());
			
			sender.sendMessage(prefix() + "Country banning has been turned " + status.getColoredName());
			break;
		case "add":
			if (args.length < 2) {
				sendFullUsage(sender);
				return;
			}
			
			options().getBannedCountries().add(args[1].toLowerCase());
			sender.sendMessage(prefix() + "Added " + args[1].toLowerCase() + " to banned country list!");
			break;
		case "remove":
			if (args.length < 2) {
				sendFullUsage(sender);
				return;
			}
			
			if (!options().isBannedCountry(args[1])) {
				sender.sendMessage(prefix() + args[1].toLowerCase() + " isn't a banned country!");
				return;
			}
			
			options().getBannedCountries().remove(args[1].toLowerCase());
			sender.sendMessage(prefix() + "Removed " + args[1].toLowerCase() + " from banned country list!");
			break;
		default:
			sendFullUsage(sender);
			break;
		}
	}
}
