package me.signatured.vpnguardplus.util;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;

import lombok.Data;
import me.signatured.vpnguardplus.VPNGuardPlus;

@Data
public class ConfigOptions {
	
	private VPNGuardPlus plugin;
	
	private String prefix;
	private String hostKickMessage;
	private String countryBanKickMessage;
	private String hostKickAlertMessage;
	private String countryBanAlertMessage;
	private boolean alertsEnabled;
	private boolean banCountryEnabled;
	private List<String> bannedCountries = new ArrayList<>();
	private long timeout;
	
	public ConfigOptions(VPNGuardPlus plugin) {
		this.plugin = plugin;
		
		prefix = Util.translate(config().getString("prefix"));
		hostKickMessage = Util.translate(config().getString("host-kick-message"));
		countryBanKickMessage = Util.translate(config().getString("country-ban-kick-message"));
		hostKickAlertMessage = Util.translate(config().getString("host-kick-alert-message"));
		countryBanAlertMessage = Util.translate(config().getString("country-ban-alert-message"));
		
		alertsEnabled = config().getBoolean("alerts");
		banCountryEnabled = config().getBoolean("ban-countries");
		
		bannedCountries = config().getStringList("banned-countries");
		
		timeout = config().getLong("timeout");
	}
	
	public boolean isBannedCountry(String country) {
		return bannedCountries.contains(country.toLowerCase());
	}
	
	private FileConfiguration config() {
		return plugin.getConfig();
	}
}
