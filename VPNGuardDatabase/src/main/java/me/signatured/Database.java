package me.signatured;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

import org.jooq.DSLContext;

/**
 * @author Joseph Robert Melsha (jrmelsha@olivet.edu)
 * @link http://www.joemelsha.com
 * @date Apr 19, 2015
 *
 * Copyright 2015 Joseph Robert Melsha
 */
public final class Database {
	
	private static final AtomicReference<DatabaseContext> context = new AtomicReference<>();
	private static boolean showStack = false;
	private static KeepAliveTask keepAliveTask = null;
	
	private Database() {
	}

	public static void setDefault(boolean test) throws SQLException {
		setFrom(test);
	}

	public static void setFrom(boolean test) throws SQLException {
		DatabaseContext context = DatabaseContext.create();

		try {
			if (test)
				try {
					context.test();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			
			set(context);
			context = null;
		} finally {
			if (context != null)
				context.close();
		}
	}

	public static void set(DatabaseContext ctx) {
		DatabaseContext old = context.getAndSet(ctx);
		if (old != null && old != ctx)
			old.close();
	}

	public static void test() throws SQLException {
		DatabaseContext ctx = context.get();
		if (ctx == null)
			throw new SQLException();
		ctx.test();
	}

	public static boolean isSetup() {
		DatabaseContext ctx = context.get();
		return ctx != null && !ctx.isClosed();
	}

	public static void close() {
		set(null);
	}

	private static DatabaseContext getCtx() {
		if (Thread.currentThread().getName().equals("Server thread"))
			onUseServerThread(new Throwable());
		
		DatabaseContext ctx = context.get();
		if (ctx == null) {
			try {
				setDefault(true); //by default, test = true.
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			ctx = context.get();
			if (ctx == null)
				throw new IllegalStateException();
		}
		return ctx;
	}
	
	public static void test0() {
		System.out.println("does this work");
	}

	public static DSLContext get() {
		DSLContext ctx = getCtx().get();
		
		checkKeepAlive();
		
		return ctx;
	}
	
	public static void checkKeepAlive() {
		if (keepAliveTask == null)
			keepAliveTask = new KeepAliveTask();
	}

	public static Connection acquireConnection() {
		return getCtx().acquireConnection();
	}

	public static DSLContext getDSLContext(Connection connection) {
		return getCtx().getDSLContext(connection);
	}
	
	private static void onUseServerThread(Throwable stack) {
		if (showStack) {
			stack.printStackTrace();
			return;
		}
		
		Iterator<StackTraceElement> it = Arrays.asList(stack.getStackTrace()).iterator();
		
		StackTraceElement call = null;
		StackTraceElement from = null;
		
		while (it.hasNext()) {
			StackTraceElement el = it.next();
			
			if (el.getClassName().equals(Database.class.getName()) && call == null)
				call = el;
			else if (!el.getClassName().equals(Database.class.getName()) && from == null)
				from = el;
		}
	}
	
	/**
	 * @param show Whether or not a full stack trace should be printed when
	 *            the Database is used on the Server thread.
	 */
	public static void setShowStack(boolean show) {
		showStack = show;
	}
}
