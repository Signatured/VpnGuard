package me.signatured.vpnguardhub.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.Data;
import lombok.Getter;
import me.signatured.vpnguardhub.VPNGuardHub;
import me.signatured.vpnguardshared.IUtil.Loggable;
import me.signatured.vpnguardshared.IUtil.Threadable;

@Data
public abstract class HubCommand implements Threadable, Loggable {
	
	@Getter
	private static List<HubCommand> commands = new ArrayList<>();
	
	private String name;
	private List<String> aliases;
	private String usage;
	
	public HubCommand(String name, String... aliases) {
		this.name = name;
		this.aliases = Arrays.asList(aliases);
		this.usage = name;
	}
	
	public static HubCommand getCommand(String cmd) {
		return commands.stream().filter(c -> c.getName().equalsIgnoreCase(cmd) || c.getAliases().contains(cmd.toLowerCase())).findAny().orElse(null);
	}
	
	public void execute(String commandLabel, String[] args) {
		if (!onExecute(commandLabel, args))
			System.out.println("Usage: " + getUsage());
	}
	
	public void register() {
		commands.add(this);
	}
	
	public VPNGuardHub getHub() {
		return VPNGuardHub.getInstance();
	}
	
	public String getUsage() {
		return "/" + usage.replace("<command>", name);
	}
	
	public abstract boolean onExecute(String commandLabel, String[] args);
}
