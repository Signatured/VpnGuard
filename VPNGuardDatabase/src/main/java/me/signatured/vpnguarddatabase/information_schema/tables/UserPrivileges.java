/**
 * This class is generated by jOOQ
 */
package me.signatured.vpnguarddatabase.information_schema.tables;


import javax.annotation.Generated;

import me.signatured.vpnguarddatabase.information_schema.InformationSchema;
import me.signatured.vpnguarddatabase.information_schema.tables.records.UserPrivilegesRecord;

import org.jooq.Field;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
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
public class UserPrivileges extends TableImpl<UserPrivilegesRecord> {

    private static final long serialVersionUID = 1984602154;

    /**
     * The reference instance of <code>information_schema.USER_PRIVILEGES</code>
     */
    public static final UserPrivileges USER_PRIVILEGES = new UserPrivileges();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UserPrivilegesRecord> getRecordType() {
        return UserPrivilegesRecord.class;
    }

    /**
     * The column <code>information_schema.USER_PRIVILEGES.GRANTEE</code>.
     */
    public final TableField<UserPrivilegesRecord, String> GRANTEE = createField("GRANTEE", org.jooq.impl.SQLDataType.VARCHAR.length(81).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>information_schema.USER_PRIVILEGES.TABLE_CATALOG</code>.
     */
    public final TableField<UserPrivilegesRecord, String> TABLE_CATALOG = createField("TABLE_CATALOG", org.jooq.impl.SQLDataType.VARCHAR.length(512).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>information_schema.USER_PRIVILEGES.PRIVILEGE_TYPE</code>.
     */
    public final TableField<UserPrivilegesRecord, String> PRIVILEGE_TYPE = createField("PRIVILEGE_TYPE", org.jooq.impl.SQLDataType.VARCHAR.length(64).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>information_schema.USER_PRIVILEGES.IS_GRANTABLE</code>.
     */
    public final TableField<UserPrivilegesRecord, String> IS_GRANTABLE = createField("IS_GRANTABLE", org.jooq.impl.SQLDataType.VARCHAR.length(3).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * Create a <code>information_schema.USER_PRIVILEGES</code> table reference
     */
    public UserPrivileges() {
        this("USER_PRIVILEGES", null);
    }

    /**
     * Create an aliased <code>information_schema.USER_PRIVILEGES</code> table reference
     */
    public UserPrivileges(String alias) {
        this(alias, USER_PRIVILEGES);
    }

    private UserPrivileges(String alias, Table<UserPrivilegesRecord> aliased) {
        this(alias, aliased, null);
    }

    private UserPrivileges(String alias, Table<UserPrivilegesRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return InformationSchema.INFORMATION_SCHEMA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserPrivileges as(String alias) {
        return new UserPrivileges(alias, this);
    }

    /**
     * Rename this table
     */
    public UserPrivileges rename(String name) {
        return new UserPrivileges(name, null);
    }
}
