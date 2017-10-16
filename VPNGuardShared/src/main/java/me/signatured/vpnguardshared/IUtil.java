package me.signatured.vpnguardshared;

import java.util.logging.Logger;

/**
 * Provides multiple sub-interfaces that have convenience methods.
 *
 */
public interface IUtil {
	
	/**
	 * Provides the {@link #sync(Object, Runnable)} convenience method.
	 *
	 */
	public static interface Syncable {
		
		/**
		 * Runs the runnable in a synchornized statement around the object.
		 */
		default void sync(Object object, Runnable runnable) {
			synchronized (object) {
				try {
					runnable.run();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	/**
	 * Provides the {@link #thread(SafeRunnable)} convenience method.
	 *
	 */
	public static interface Threadable {
		
		/**
		 * Starts the given Runnable in a new Thread.
		 * 
		 * @param r The runnable to run.
		 * @return The Thread started.
		 */
		default Thread thread(SafeRunnable r) {
			Thread t = new Thread() {
				@Override
				public void run() {
					try {
						r.run();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			};
			t.start();
			return t;
		}
		
		/**
		 * Starts the given Runnable in a new Thread.
		 * 
		 * @param name The name of the thread.
		 * @param r The runnable to run.
		 * @return The Thread started.
		 */
		default Thread thread(String name, SafeRunnable r) {
			Thread t = new Thread(name) {
				@Override
				public void run() {
					try {
						r.run();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			};
			t.start();
			return t;
		}
		
	}
	
	public static interface Loggable {
		
		default void log(String msg) {
			log().info(msg);
		}
		
		default void warning(String msg) {
			log().warning(msg);
		}
		
		default Logger log() {
			return Logger.getGlobal();
		}
	}

}