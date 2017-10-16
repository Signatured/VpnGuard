package me.signatured.vpnguardhub.command.cmds;

import me.signatured.vpnguardhub.XioaxAPI;
import me.signatured.vpnguardhub.command.HubCommand;
import me.signatured.vpnguardshared.AddressInfo;

public class LookupCommand extends HubCommand {

	public LookupCommand() {
		super("lookup");
		setUsage("<command> <ip>");
	}

	@Override
	public boolean onExecute(String commandLabel, String[] args) {
		if (args.length == 0 || !XioaxAPI.isIp(args[0]))
			return false;
		String ip = args[0];
		
		log("Looking up " + ip + "...");
		thread(() -> {
			AddressInfo info = XioaxAPI.getAddressInfo(ip);
			
			log("Host: " + info.isHost());
			log("Organization: " + info.getOrg());
			log("Country: " + info.getCountry());
			log("Subdivision: " + info.getSubdivision());
			log("City: " + info.getCity());
			log("Postal: " + info.getPostal());
			log("Latitude: " + info.getLatitude());
			log("Longitude: " + info.getLongitude());
			
			Thread.currentThread().interrupt();
		});
		
		return true;
	}

}
