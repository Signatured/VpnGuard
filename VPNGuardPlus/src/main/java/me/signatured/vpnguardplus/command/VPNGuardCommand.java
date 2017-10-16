package me.signatured.vpnguardplus.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import lombok.Data;
import lombok.Getter;
import me.signatured.vpnguardplus.VPNGuardPlus;
import me.signatured.vpnguardplus.util.ConfigOptions;

@Data
public abstract class VPNGuardCommand implements IVPNGuardCommand {
	
	@Getter
	private static List<VPNGuardCommand> commands = new ArrayList<>();
	
	private String name;
	private List<String> aliases = new ArrayList<>();
	private String permission;
	private String description;
	private String usage;

	public VPNGuardCommand(String name, String... aliases) {
		this.name = name;
		this.aliases = Arrays.asList(aliases);
		
		commands.add(this);
	}
	
	public static VPNGuardCommand getCommand(String cmd) {
		return commands.stream()
				.filter(c -> c.getName().equalsIgnoreCase(cmd) || c.getAliases().contains(cmd.toLowerCase())).findAny()
				.orElse(null);
	}
	
	@Override
	public void run(CommandSender sender, String commandLabel, Command cmd, String[] args) {
		if (isPlayer(sender)) {
			Player player = asPlayer(sender);
			
			if (permission != null && !player.hasPermission(permission)) {
				player.sendMessage(ChatColor.RED + "Invalid permissions!");
				return;
			}
		}
		
		run(sender, Arrays.copyOfRange(args, 1, args.length));
	}
	
	@Override
	public ConfigOptions options() {
		return VPNGuardPlus.getInstance().getOptions();
	}
	
	@Override
	public String getFullUsage() {
		return prefix() + ChatColor.AQUA + usage + ChatColor.RESET + " - " + ChatColor.YELLOW + description;
	}
	
	@Override
	public String prefix() {
		return options().getPrefix();
	}
	
	@Override
	public void sendFullUsage(CommandSender sender) {
		sender.sendMessage(getFullUsage());
	}
	
	public boolean isPlayer(CommandSender sender) {
		return sender instanceof Player;
	}
	
	public Player asPlayer(CommandSender sender) {
		return (Player) sender;
	}

}
