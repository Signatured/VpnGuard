/**
 * This class is generated by jOOQ
 */
package me.signatured.vpnguarddatabase.vpnguard.tables.records;


import java.sql.Timestamp;

import javax.annotation.Generated;

import me.signatured.vpnguarddatabase.vpnguard.tables.CachedIp;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record15;
import org.jooq.Row15;
import org.jooq.impl.UpdatableRecordImpl;


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
public class CachedIpRecord extends UpdatableRecordImpl<CachedIpRecord> implements Record15<Integer, String, String, String, Boolean, String, String, String, String, String, String, String, Long, Long, Timestamp> {

    private static final long serialVersionUID = 1724168679;

    /**
     * Setter for <code>vpnguard.cached_ip.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>vpnguard.cached_ip.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>vpnguard.cached_ip.ip</code>.
     */
    public void setIp(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>vpnguard.cached_ip.ip</code>.
     */
    public String getIp() {
        return (String) get(1);
    }

    /**
     * Setter for <code>vpnguard.cached_ip.player_name</code>.
     */
    public void setPlayerName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>vpnguard.cached_ip.player_name</code>.
     */
    public String getPlayerName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>vpnguard.cached_ip.player_uuid</code>.
     */
    public void setPlayerUuid(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>vpnguard.cached_ip.player_uuid</code>.
     */
    public String getPlayerUuid() {
        return (String) get(3);
    }

    /**
     * Setter for <code>vpnguard.cached_ip.host</code>.
     */
    public void setHost(Boolean value) {
        set(4, value);
    }

    /**
     * Getter for <code>vpnguard.cached_ip.host</code>.
     */
    public Boolean getHost() {
        return (Boolean) get(4);
    }

    /**
     * Setter for <code>vpnguard.cached_ip.org</code>.
     */
    public void setOrg(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>vpnguard.cached_ip.org</code>.
     */
    public String getOrg() {
        return (String) get(5);
    }

    /**
     * Setter for <code>vpnguard.cached_ip.country_name</code>.
     */
    public void setCountryName(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>vpnguard.cached_ip.country_name</code>.
     */
    public String getCountryName() {
        return (String) get(6);
    }

    /**
     * Setter for <code>vpnguard.cached_ip.country_code</code>.
     */
    public void setCountryCode(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>vpnguard.cached_ip.country_code</code>.
     */
    public String getCountryCode() {
        return (String) get(7);
    }

    /**
     * Setter for <code>vpnguard.cached_ip.subdivision_name</code>.
     */
    public void setSubdivisionName(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>vpnguard.cached_ip.subdivision_name</code>.
     */
    public String getSubdivisionName() {
        return (String) get(8);
    }

    /**
     * Setter for <code>vpnguard.cached_ip.subdivision_code</code>.
     */
    public void setSubdivisionCode(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>vpnguard.cached_ip.subdivision_code</code>.
     */
    public String getSubdivisionCode() {
        return (String) get(9);
    }

    /**
     * Setter for <code>vpnguard.cached_ip.city</code>.
     */
    public void setCity(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>vpnguard.cached_ip.city</code>.
     */
    public String getCity() {
        return (String) get(10);
    }

    /**
     * Setter for <code>vpnguard.cached_ip.postal</code>.
     */
    public void setPostal(String value) {
        set(11, value);
    }

    /**
     * Getter for <code>vpnguard.cached_ip.postal</code>.
     */
    public String getPostal() {
        return (String) get(11);
    }

    /**
     * Setter for <code>vpnguard.cached_ip.location_lat</code>.
     */
    public void setLocationLat(Long value) {
        set(12, value);
    }

    /**
     * Getter for <code>vpnguard.cached_ip.location_lat</code>.
     */
    public Long getLocationLat() {
        return (Long) get(12);
    }

    /**
     * Setter for <code>vpnguard.cached_ip.location_long</code>.
     */
    public void setLocationLong(Long value) {
        set(13, value);
    }

    /**
     * Getter for <code>vpnguard.cached_ip.location_long</code>.
     */
    public Long getLocationLong() {
        return (Long) get(13);
    }

    /**
     * Setter for <code>vpnguard.cached_ip.time_inserted</code>.
     */
    public void setTimeInserted(Timestamp value) {
        set(14, value);
    }

    /**
     * Getter for <code>vpnguard.cached_ip.time_inserted</code>.
     */
    public Timestamp getTimeInserted() {
        return (Timestamp) get(14);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record15 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row15<Integer, String, String, String, Boolean, String, String, String, String, String, String, String, Long, Long, Timestamp> fieldsRow() {
        return (Row15) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row15<Integer, String, String, String, Boolean, String, String, String, String, String, String, String, Long, Long, Timestamp> valuesRow() {
        return (Row15) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return CachedIp.CACHED_IP.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return CachedIp.CACHED_IP.IP;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return CachedIp.CACHED_IP.PLAYER_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return CachedIp.CACHED_IP.PLAYER_UUID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field5() {
        return CachedIp.CACHED_IP.HOST;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return CachedIp.CACHED_IP.ORG;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return CachedIp.CACHED_IP.COUNTRY_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field8() {
        return CachedIp.CACHED_IP.COUNTRY_CODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field9() {
        return CachedIp.CACHED_IP.SUBDIVISION_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field10() {
        return CachedIp.CACHED_IP.SUBDIVISION_CODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field11() {
        return CachedIp.CACHED_IP.CITY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field12() {
        return CachedIp.CACHED_IP.POSTAL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field13() {
        return CachedIp.CACHED_IP.LOCATION_LAT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field14() {
        return CachedIp.CACHED_IP.LOCATION_LONG;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field15() {
        return CachedIp.CACHED_IP.TIME_INSERTED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getIp();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getPlayerName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getPlayerUuid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value5() {
        return getHost();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getOrg();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getCountryName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value8() {
        return getCountryCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value9() {
        return getSubdivisionName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value10() {
        return getSubdivisionCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value11() {
        return getCity();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value12() {
        return getPostal();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value13() {
        return getLocationLat();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value14() {
        return getLocationLong();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value15() {
        return getTimeInserted();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CachedIpRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CachedIpRecord value2(String value) {
        setIp(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CachedIpRecord value3(String value) {
        setPlayerName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CachedIpRecord value4(String value) {
        setPlayerUuid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CachedIpRecord value5(Boolean value) {
        setHost(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CachedIpRecord value6(String value) {
        setOrg(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CachedIpRecord value7(String value) {
        setCountryName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CachedIpRecord value8(String value) {
        setCountryCode(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CachedIpRecord value9(String value) {
        setSubdivisionName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CachedIpRecord value10(String value) {
        setSubdivisionCode(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CachedIpRecord value11(String value) {
        setCity(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CachedIpRecord value12(String value) {
        setPostal(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CachedIpRecord value13(Long value) {
        setLocationLat(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CachedIpRecord value14(Long value) {
        setLocationLong(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CachedIpRecord value15(Timestamp value) {
        setTimeInserted(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CachedIpRecord values(Integer value1, String value2, String value3, String value4, Boolean value5, String value6, String value7, String value8, String value9, String value10, String value11, String value12, Long value13, Long value14, Timestamp value15) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        value14(value14);
        value15(value15);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CachedIpRecord
     */
    public CachedIpRecord() {
        super(CachedIp.CACHED_IP);
    }

    /**
     * Create a detached, initialised CachedIpRecord
     */
    public CachedIpRecord(Integer id, String ip, String playerName, String playerUuid, Boolean host, String org, String countryName, String countryCode, String subdivisionName, String subdivisionCode, String city, String postal, Long locationLat, Long locationLong, Timestamp timeInserted) {
        super(CachedIp.CACHED_IP);

        set(0, id);
        set(1, ip);
        set(2, playerName);
        set(3, playerUuid);
        set(4, host);
        set(5, org);
        set(6, countryName);
        set(7, countryCode);
        set(8, subdivisionName);
        set(9, subdivisionCode);
        set(10, city);
        set(11, postal);
        set(12, locationLat);
        set(13, locationLong);
        set(14, timeInserted);
    }
}