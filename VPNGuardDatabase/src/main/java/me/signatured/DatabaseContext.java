package me.signatured;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicBoolean;

import org.jooq.ConnectionProvider;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.conf.BackslashEscaping;
import org.jooq.conf.ParamType;
import org.jooq.conf.RenderKeywordStyle;
import org.jooq.conf.Settings;
import org.jooq.conf.StatementType;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DSL;

import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;

public class DatabaseContext implements AutoCloseable {

	private BoneCP source;
	private ConnectionProvider provider;
	private Settings settings;
	private SQLDialect dialect;
	protected final AtomicBoolean shutdown = new AtomicBoolean();

	public static DatabaseContext create() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		
		SQLDialect dialect = SQLDialect.MYSQL;
		BoneCPConfig cfg = config("url", "username", "pass", 300000L, 300L, 3600L, 0L, 3, 4);
		BoneCP cp = new BoneCP(cfg);
		Settings g = DatabaseContext.defaultSettings();
		return new DatabaseContext(cp, g, dialect);
	}
	
	public DatabaseContext(BoneCP source, Settings settings, SQLDialect dialect) {
		this.source = source;
		this.settings = settings;
		this.dialect = dialect;
		provider = new ConnectionProvider() {
			@Override
			public Connection acquire() throws DataAccessException {
				if (shutdown.get())
					throw new DataAccessException("Shutdown");
				try {
					return source.getConnection();
				} catch (SQLException e) {
					throw new DataAccessException(e.getMessage(), e);
				}
			}

			@Override
			public void release(Connection connection) throws DataAccessException {
				try {
					connection.close();
				} catch (SQLException e) {
					throw new DataAccessException(e.getMessage(), e);
				}
			}
		};
	}
	
	public DSLContext get() {
		return DSL.using(provider, dialect, settings);
	}

	public Connection acquireConnection() {
		return provider.acquire();
	}

	public DSLContext getDSLContext(Connection connection) {
		return DSL.using(connection, dialect, settings);
	}
	
	public boolean isClosed() {
		return shutdown.get();
	}

	@Override
	public void close() {
		if (shutdown.getAndSet(true))
			return;
		
		close0();
	}
	
	@Override
	protected void finalize() throws Throwable {
		try {
			close();
		} finally {
			super.finalize();
		}
	}
	
	protected void close0() {
		source.shutdown();
	}
	
	public void test() throws SQLException {
		if (shutdown.get())
			throw new SQLException();
		String query = source.getConfig().getConnectionTestStatement();
		if (query != null)
			try (Connection connection = source.getConnection()) {
				connection.nativeSQL(query);
			}
	}

	public static BoneCPConfig config(String url, String username, String password,
			Long connectionTimeoutInMs, Long idleConnectionTestPeriodInSeconds, Long idleMaxAgeInSeconds,
			Long maxConnectionAgeInSeconds, Integer maxConnectionsPerPartition, Integer partitionCount) {
		BoneCPConfig cfg = new BoneCPConfig();
		cfg.setJdbcUrl(url);
		cfg.setConnectionTestStatement("SELECT 1");
		cfg.setUsername(username);
		cfg.setPassword(password);
		cfg.setAcquireIncrement(1);
		cfg.setAcquireRetryAttempts(0);
		cfg.setAcquireRetryDelayInMs(0);
		cfg.setCloseConnectionWatch(false);
		cfg.setCloseOpenStatements(false);
		if (connectionTimeoutInMs != null)
			cfg.setConnectionTimeoutInMs(connectionTimeoutInMs); // - 5 minutes
		// cfg.setDefaultCatalog(null);
		cfg.setDefaultAutoCommit(true);
		cfg.setDefaultReadOnly(false);
		cfg.setDefaultTransactionIsolation("SERIALIZABLE");
		cfg.setDeregisterDriverOnClose(false);
		cfg.setDetectUnclosedStatements(false);
		cfg.setDetectUnresolvedTransactions(false);
		cfg.setDisableConnectionTracking(true);
		cfg.setDisableJMX(true);
		cfg.setExternalAuth(false);
		if (idleConnectionTestPeriodInSeconds != null)
			cfg.setIdleConnectionTestPeriodInSeconds(idleConnectionTestPeriodInSeconds); // -
																							// 5
																							// minutes
		if (idleMaxAgeInSeconds != null)
			cfg.setIdleMaxAgeInSeconds(idleMaxAgeInSeconds); // - 1 hour
		cfg.setLazyInit(true);
		cfg.setLogStatementsEnabled(false);
		if (maxConnectionAgeInSeconds != null)
			cfg.setMaxConnectionAgeInSeconds(maxConnectionAgeInSeconds); // - 0
		if (maxConnectionsPerPartition != null)
			cfg.setMaxConnectionsPerPartition(maxConnectionsPerPartition); // -
																			// 3
		cfg.setNullOnConnectionTimeout(false);
		if (partitionCount != null)
			cfg.setPartitionCount(partitionCount); // - 4
		cfg.setPoolAvailabilityThreshold(0);
		cfg.setPoolStrategy("DEFAULT");
		cfg.setQueryExecuteTimeLimitInMs(0);
		cfg.setResetConnectionOnClose(false);
		cfg.setServiceOrder("LIFO");
		cfg.setStatementsCacheSize(0);
		cfg.setStatisticsEnabled(false);
		cfg.setTransactionRecoveryEnabled(false);
		cfg.sanitize();
		return cfg;
	}

	public static Settings defaultSettings() {
		return defaultSettings(new Settings());
	}

	public static Settings defaultSettings(Settings g) {
		g.setAttachRecords(true);
		g.setRenderSchema(true);
		g.setStatementType(StatementType.PREPARED_STATEMENT);
		g.setParamType(ParamType.INDEXED);
		g.setExecuteLogging(false);
		g.setExecuteWithOptimisticLocking(false);
		g.setUpdatablePrimaryKeys(true);
		g.setRenderKeywordStyle(RenderKeywordStyle.UPPER);
		g.setReflectionCaching(true);
		g.setRenderFormatted(false);
		g.setBackslashEscaping(BackslashEscaping.DEFAULT);
		// s.setRenderMapping();
		g.setFetchWarnings(false);
		g.setRenderScalarSubqueriesForStoredFunctions(false);
		return g;
	}
}
