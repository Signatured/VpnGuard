/**
 * This class is generated by jOOQ
 */
package me.signatured.vpnguarddatabase.vpnguard.tables;


import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import me.signatured.vpnguarddatabase.vpnguard.Keys;
import me.signatured.vpnguarddatabase.vpnguard.Vpnguard;
import me.signatured.vpnguarddatabase.vpnguard.tables.records.CachedIpRecord;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CachedIp extends TableImpl<CachedIpRecord> {

    private static final long serialVersionUID = -1347798228;

    /**
     * The reference instance of <code>vpnguard.cached_ip</code>
     */
    public static final CachedIp CACHED_IP = new CachedIp();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CachedIpRecord> getRecordType() {
        return CachedIpRecord.class;
    }

    /**
     * The column <code>vpnguard.cached_ip.id</code>.
     */
    public final TableField<CachedIpRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>vpnguard.cached_ip.ip</code>.
     */
    public final TableField<CachedIpRecord, String> IP = createField("ip", org.jooq.impl.SQLDataType.VARCHAR.length(50).nullable(false), this, "");

    /**
     * The column <code>vpnguard.cached_ip.player_name</code>.
     */
    public final TableField<CachedIpRecord, String> PLAYER_NAME = createField("player_name", org.jooq.impl.SQLDataType.VARCHAR.length(50), this, "");

    /**
     * The column <code>vpnguard.cached_ip.player_uuid</code>.
     */
    public final TableField<CachedIpRecord, String> PLAYER_UUID = createField("player_uuid", org.jooq.impl.SQLDataType.VARCHAR.length(50), this, "");

    /**
     * The column <code>vpnguard.cached_ip.host</code>.
     */
    public final TableField<CachedIpRecord, Boolean> HOST = createField("host", org.jooq.impl.SQLDataType.BIT.nullable(false).defaultValue(org.jooq.impl.DSL.inline("b'0'", org.jooq.impl.SQLDataType.BIT)), this, "");

    /**
     * The column <code>vpnguard.cached_ip.org</code>.
     */
    public final TableField<CachedIpRecord, String> ORG = createField("org", org.jooq.impl.SQLDataType.VARCHAR.length(100).nullable(false), this, "");

    /**
     * The column <code>vpnguard.cached_ip.country_name</code>.
     */
    public final TableField<CachedIpRecord, String> COUNTRY_NAME = createField("country_name", org.jooq.impl.SQLDataType.VARCHAR.length(50).nullable(false), this, "");

    /**
     * The column <code>vpnguard.cached_ip.country_code</code>.
     */
    public final TableField<CachedIpRecord, String> COUNTRY_CODE = createField("country_code", org.jooq.impl.SQLDataType.VARCHAR.length(50).nullable(false), this, "");

    /**
     * The column <code>vpnguard.cached_ip.subdivision_name</code>.
     */
    public final TableField<CachedIpRecord, String> SUBDIVISION_NAME = createField("subdivision_name", org.jooq.impl.SQLDataType.VARCHAR.length(50).nullable(false), this, "");

    /**
     * The column <code>vpnguard.cached_ip.subdivision_code</code>.
     */
    public final TableField<CachedIpRecord, String> SUBDIVISION_CODE = createField("subdivision_code", org.jooq.impl.SQLDataType.VARCHAR.length(50).nullable(false), this, "");

    /**
     * The column <code>vpnguard.cached_ip.city</code>.
     */
    public final TableField<CachedIpRecord, String> CITY = createField("city", org.jooq.impl.SQLDataType.VARCHAR.length(50).nullable(false), this, "");

    /**
     * The column <code>vpnguard.cached_ip.postal</code>.
     */
    public final TableField<CachedIpRecord, String> POSTAL = createField("postal", org.jooq.impl.SQLDataType.VARCHAR.length(50).nullable(false), this, "");

    /**
     * The column <code>vpnguard.cached_ip.location_lat</code>.
     */
    public final TableField<CachedIpRecord, Long> LOCATION_LAT = createField("location_lat", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>vpnguard.cached_ip.location_long</code>.
     */
    public final TableField<CachedIpRecord, Long> LOCATION_LONG = createField("location_long", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>vpnguard.cached_ip.time_inserted</code>.
     */
    public final TableField<CachedIpRecord, Timestamp> TIME_INSERTED = createField("time_inserted", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.inline("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * Create a <code>vpnguard.cached_ip</code> table reference
     */
    public CachedIp() {
        this("cached_ip", null);
    }

    /**
     * Create an aliased <code>vpnguard.cached_ip</code> table reference
     */
    public CachedIp(String alias) {
        this(alias, CACHED_IP);
    }

    private CachedIp(String alias, Table<CachedIpRecord> aliased) {
        this(alias, aliased, null);
    }

    private CachedIp(String alias, Table<CachedIpRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Vpnguard.VPNGUARD;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<CachedIpRecord, Integer> getIdentity() {
        return Keys.IDENTITY_CACHED_IP;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<CachedIpRecord> getPrimaryKey() {
        return Keys.KEY_CACHED_IP_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<CachedIpRecord>> getKeys() {
        return Arrays.<UniqueKey<CachedIpRecord>>asList(Keys.KEY_CACHED_IP_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CachedIp as(String alias) {
        return new CachedIp(alias, this);
    }

    /**
     * Rename this table
     */
    public CachedIp rename(String name) {
        return new CachedIp(name, null);
    }
}
