package me.signatured.vpnguardshared.messages;

import lombok.Builder;
import lombok.Data;
import me.signatured.vpnguardshared.AddressInfo;

@Data
@Builder
public class ResponseMessage {

	private String playerName;
	private String uuid;
	private String ip;
	private AddressInfo info;
	private boolean command;
	private String commandSender;
}
