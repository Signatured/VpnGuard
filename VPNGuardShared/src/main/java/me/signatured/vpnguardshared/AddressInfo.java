package me.signatured.vpnguardshared;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AddressInfo {

	private String ip, org, country, countryCode, subdivision, subdivisionCode, city, postal;
	private boolean host;
	private long latitude, longitude;

}
