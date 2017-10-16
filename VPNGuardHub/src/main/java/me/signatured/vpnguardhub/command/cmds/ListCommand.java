package me.signatured.vpnguardhub.command.cmds;

import me.signatured.vpnguardhub.command.HubCommand;
import me.signatured.vpnguardshared.network.NetworkClient;

public class ListCommand extends HubCommand {

	public ListCommand() {
		super("list");
		setUsage("<command>");
	}

	@Override
	public boolean onExecute(String commandLabel, String[] args) {
		log("Currently " + getHub().getConnected().size() + " clients connected.\n");
		
		for (NetworkClient client : getHub().getConnected())
			log("- " + client);
		
		return true;
	}

}
