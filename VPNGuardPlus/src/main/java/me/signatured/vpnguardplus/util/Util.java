package me.signatured.vpnguardplus.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import me.signatured.vpnguardshared.AddressInfo;

public class Util {
	
	public static void broadcastAlert(String message) {
		Bukkit.getOnlinePlayers().stream().filter(p -> p.hasPermission("vpnguard.notify"))
				.forEach(p -> p.sendMessage(message));
	}
	
	public static String translate(String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}
	
	public static String format(String message, AddressInfo info) {
		return message.replace("%ip%", info.getIp()).replace("%org%", info.getOrg()).replace("%country%", info.getCountry()).replace("%subdivision%", info.getSubdivision());
	}
	
	public static String format(String message, Player player, AddressInfo info) {
		return format(message, info).replace("%player%", player.getName());
	}
	
	public static boolean isIp(String text) {
	    Pattern p = Pattern.compile("^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$");
	    Matcher m = p.matcher(text);
	    return m.find();
	}
	
	public static final String VERTICAL_LINE = ChatColor.DARK_GRAY + "\u2551 ";
	public static final String HORIZONTAL_LINE;

	static {
		StringBuilder builder = new StringBuilder(25);
		builder.append(ChatColor.DARK_GRAY + "").append(ChatColor.BOLD + "");
		builder.append('\u255A');
		for (int i = 0; i < 20; ++i) {
			builder.append('\u2550');
		}

		HORIZONTAL_LINE = builder.toString();
	}
}
