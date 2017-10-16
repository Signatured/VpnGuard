package me.signatured.vpnguardplus;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

import lombok.AllArgsConstructor;
import me.signatured.vpnguardplus.util.ConfigOptions;
import me.signatured.vpnguardplus.util.Util;
import me.signatured.vpnguardshared.messages.ResponseMessage;

@AllArgsConstructor
public class VPNGuardListener implements Listener {
	
	private ConfigOptions options;
	private Map<UUID, ResponseMessage> found = new HashMap<>();
	
	public VPNGuardListener(VPNGuardPlus plugin) {
		this.options = plugin.getOptions();
	}
	
	@EventHandler
	public void onAsyncPreLogin(AsyncPlayerPreLoginEvent event) {
		VPNGuardAPI.sendRequest(event.getName(), event.getUniqueId().toString(), event.getAddress().getHostName());
		
		Future<ResponseMessage> response = getVPNResponse(event);
		
		try {
			ResponseMessage msg = response.get(options.getTimeout(), TimeUnit.MILLISECONDS);
			if (msg == null)
				return;
			
			found.put(event.getUniqueId(), msg);
		} catch (InterruptedException e) {
			
		} catch (ExecutionException e) {
			
		} catch (TimeoutException e) {
			System.err.println(ChatColor.RED + "[VPNGuardPlus] Request timed out for " + event.getName() + ". Could not check if player is using VPN.");
			response.cancel(false);
		}
	}
	
	@EventHandler
	public void onLogin(PlayerLoginEvent event) {
		Player player = event.getPlayer();
		ResponseMessage msg = found.get(player.getUniqueId());
		if (msg == null)
			return;
		
		if (msg.getInfo().isHost()) {
			if (player.hasPermission("vpnguardplus.bypass"))
				return;

			event.setResult(Result.KICK_BANNED);
			event.setKickMessage(Util.format(options.getHostKickMessage(), msg.getInfo()));

			Util.broadcastAlert(options.getPrefix() + Util.format(options.getHostKickAlertMessage(), player, msg.getInfo()));
			return;
		} else if (options.isBanCountryEnabled() && options.isBannedCountry(msg.getInfo().getCountry())) {
			event.setResult(Result.KICK_BANNED);
			event.setKickMessage(Util.format(options.getCountryBanKickMessage(), msg.getInfo()));

			Util.broadcastAlert(options.getPrefix() + Util.format(options.getCountryBanAlertMessage(), player, msg.getInfo()));
			return;
		}
		
		found.remove(player.getUniqueId());
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		VPNGuardPlus.getInstance().getResponses().remove(event.getPlayer().getUniqueId());
		found.remove(event.getPlayer().getUniqueId());
	}
	
	public Future<ResponseMessage> getVPNResponse(AsyncPlayerPreLoginEvent event) {
    	ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
    	
    	return executor.submit(() -> {
    		try {
    			UUID uuid = event.getUniqueId();
    			ResponseMessage msg = null;
    			
    			while (true) {
    				if (VPNGuardPlus.getInstance().getResponses().containsKey(uuid)) {
    					msg = VPNGuardPlus.getInstance().getResponses().get(uuid);
    					VPNGuardPlus.getInstance().getResponses().remove(uuid);
    					break;
    				}
    				
    				Thread.sleep(50);
    			}
    			
    			return msg;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
    	});
    }
}
