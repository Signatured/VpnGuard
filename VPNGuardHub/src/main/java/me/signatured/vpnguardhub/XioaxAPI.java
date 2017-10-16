package me.signatured.vpnguardhub;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONException;
import org.json.JSONObject;

import me.signatured.vpnguardshared.AddressInfo;
import me.signatured.vpnguardshared.IUtil.Threadable;

public class XioaxAPI implements Threadable {

	private static final String KEY = "DSFSFSDF";

	public static AddressInfo getAddressInfo(String ip) throws JSONException, IOException {
		InputStream is = new URL("http://tools.xioax.com/networking/v2/json/" + ip + "/" + KEY).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONObject json = new JSONObject(jsonText);
			JSONObject country = json.getJSONObject("country");
			JSONObject subdivision = json.getJSONObject("subdivision");
			JSONObject location = json.getJSONObject("location");

			return AddressInfo.builder().ip(ip).org(json.getString("org")).country(country.getString("name"))
					.countryCode(country.getString("code")).subdivision(subdivision.getString("name"))
					.subdivisionCode(subdivision.getString("code")).city(json.getString("city"))
					.postal(json.getString("postal")).latitude(location.getLong("lat"))
					.longitude(location.getLong("long")).build();
		} finally {
			is.close();
		}
	}
	
	public static boolean isIp(String text) {
	    Pattern p = Pattern.compile("^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$");
	    Matcher m = p.matcher(text);
	    return m.find();
	}

	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}
}
