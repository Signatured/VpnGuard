package me.signatured.vpnguardplus.util;

import org.bukkit.ChatColor;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Status {
	
	ON("On", ChatColor.GREEN), OFF("Off", ChatColor.RED);
	
	private String name;
	private ChatColor color;
	
	public String getColoredName() {
		return color + name;
	}
	
	public static Status getStatus(boolean b) {
		return b ? ON : OFF;
	}
	
	public static Status getStatus(String status) {
		switch (status.toLowerCase()) {
		
		case "on":
		case "enable":
			return ON;
		case "off":
		case "disable":
			return OFF;
		}
		
		return null;
	}
	
	public boolean getBoolean() {
		switch (this) {
		
		case ON:
			return true;
		case OFF:
			return false;
		default:
			return false;
		}
	}
}
