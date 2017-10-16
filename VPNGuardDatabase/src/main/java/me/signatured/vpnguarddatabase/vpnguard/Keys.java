/**
 * This class is generated by jOOQ
 */
package me.signatured.vpnguarddatabase.vpnguard;


import javax.annotation.Generated;

import me.signatured.vpnguarddatabase.vpnguard.tables.CachedIp;
import me.signatured.vpnguarddatabase.vpnguard.tables.records.CachedIpRecord;

import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.AbstractKeys;


/**
 * A class modelling foreign key relationships between tables of the <code>vpnguard</code> 
 * schema
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<CachedIpRecord, Integer> IDENTITY_CACHED_IP = Identities0.IDENTITY_CACHED_IP;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<CachedIpRecord> KEY_CACHED_IP_PRIMARY = UniqueKeys0.KEY_CACHED_IP_PRIMARY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 extends AbstractKeys {
        public static Identity<CachedIpRecord, Integer> IDENTITY_CACHED_IP = createIdentity(CachedIp.CACHED_IP, CachedIp.CACHED_IP.ID);
    }

    private static class UniqueKeys0 extends AbstractKeys {
        public static final UniqueKey<CachedIpRecord> KEY_CACHED_IP_PRIMARY = createUniqueKey(CachedIp.CACHED_IP, "KEY_cached_ip_PRIMARY", CachedIp.CACHED_IP.ID);
    }
}