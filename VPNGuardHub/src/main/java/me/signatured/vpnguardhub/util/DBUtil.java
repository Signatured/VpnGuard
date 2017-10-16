package me.signatured.vpnguardhub.util;

import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

import me.signatured.Database;
import me.signatured.vpnguarddatabase.vpnguard.Tables;
import me.signatured.vpnguarddatabase.vpnguard.tables.records.CachedIpRecord;
import me.signatured.vpnguardshared.AddressInfo;
import me.signatured.vpnguardshared.IUtil.Threadable;

public class DBUtil implements Threadable {
	
	public AddressInfo getCachedInfo(String ip, String name, String uuid) {
		CachedIpRecord cached = Database.get().selectFrom(Tables.CACHED_IP)
				.where(Tables.CACHED_IP.IP.eq(ip)
						.and(Tables.CACHED_IP.TIME_INSERTED.greaterOrEqual(
								new Timestamp(System.currentTimeMillis() - TimeUnit.HOURS.toMillis(24 * 14)))))
				.fetchAny();
		
		if (cached != null)
			return AddressInfo.builder().ip(cached.getIp()).host(cached.getHost()).org(cached.getOrg())
					.country(cached.getCountryName()).countryCode(cached.getCountryCode())
					.subdivision(cached.getSubdivisionName()).subdivisionCode(cached.getSubdivisionCode())
					.city(cached.getCity()).postal(cached.getPostal()).latitude(cached.getLocationLat())
					.longitude(cached.getLocationLong()).build();
		
		return null;
	}
	
	public void insertIp(AddressInfo info, String playerName, String uuid) {
		thread(() -> {
			CachedIpRecord cached = Database.get().newRecord(Tables.CACHED_IP);
			
			cached.setIp(info.getIp());
			cached.setPlayerName(playerName);
			cached.setPlayerUuid(uuid);
			cached.setHost(info.isHost());
			cached.setOrg(info.getOrg());
			cached.setCountryName(info.getCountry());
			cached.setCountryCode(info.getCountryCode());
			cached.setSubdivisionName(info.getSubdivision());
			cached.setSubdivisionCode(info.getSubdivisionCode());
			cached.setCity(info.getCity());
			cached.setPostal(info.getPostal());
			cached.setLocationLat(info.getLatitude());
			cached.setLocationLong(info.getLongitude());
			
			cached.insert();
			Thread.currentThread().interrupt();
		});
	}
}
