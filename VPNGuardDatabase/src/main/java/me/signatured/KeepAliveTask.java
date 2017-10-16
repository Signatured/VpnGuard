package me.signatured;

import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;

public class KeepAliveTask extends Timer {
	
	public KeepAliveTask() {
		this.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				try {
					Database.test();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}, 0L, 1000 * 60 * 3);
	}
}
