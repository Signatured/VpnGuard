package me.signatured.vpnguardshared;

/**
 * A runnable that might throw an Exception when running.
 */
@FunctionalInterface
public interface SafeRunnable {
	
	void run() throws Exception;
	
}
