package me.signatured.vpnguardplus.util;

public interface Callback<V> {
	
	/**
     * Called when the result is done.
     *
     * @param result the result of the computation
     */
	public void done(V result);

}
