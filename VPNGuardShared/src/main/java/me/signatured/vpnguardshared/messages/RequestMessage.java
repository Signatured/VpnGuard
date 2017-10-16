package me.signatured.vpnguardshared.messages;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestMessage {
	
	private String playerName;
	private String uuid;
	private String ip;
	private boolean command;
	private String commandSender;
}
