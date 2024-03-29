/**
 * This class is generated by jOOQ
 */
package me.signatured.vpnguarddatabase.information_schema.tables;


import javax.annotation.Generated;

import me.signatured.vpnguarddatabase.information_schema.InformationSchema;
import me.signatured.vpnguarddatabase.information_schema.tables.records.InnodbSysTablesRecord;

import org.jooq.Field;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.TableImpl;
import org.jooq.types.UInteger;
import org.jooq.types.ULong;


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
public class InnodbSysTables extends TableImpl<InnodbSysTablesRecord> {

    private static final long serialVersionUID = 855652429;

    /**
     * The reference instance of <code>information_schema.INNODB_SYS_TABLES</code>
     */
    public static final InnodbSysTables INNODB_SYS_TABLES = new InnodbSysTables();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<InnodbSysTablesRecord> getRecordType() {
        return InnodbSysTablesRecord.class;
    }

    /**
     * The column <code>information_schema.INNODB_SYS_TABLES.TABLE_ID</code>.
     */
    public final TableField<InnodbSysTablesRecord, ULong> TABLE_ID = createField("TABLE_ID", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.BIGINTUNSIGNED)), this, "");

    /**
     * The column <code>information_schema.INNODB_SYS_TABLES.NAME</code>.
     */
    public final TableField<InnodbSysTablesRecord, String> NAME = createField("NAME", org.jooq.impl.SQLDataType.VARCHAR.length(655).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>information_schema.INNODB_SYS_TABLES.FLAG</code>.
     */
    public final TableField<InnodbSysTablesRecord, Integer> FLAG = createField("FLAG", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>information_schema.INNODB_SYS_TABLES.N_COLS</code>.
     */
    public final TableField<InnodbSysTablesRecord, Integer> N_COLS = createField("N_COLS", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>information_schema.INNODB_SYS_TABLES.SPACE</code>.
     */
    public final TableField<InnodbSysTablesRecord, Integer> SPACE = createField("SPACE", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>information_schema.INNODB_SYS_TABLES.FILE_FORMAT</code>.
     */
    public final TableField<InnodbSysTablesRecord, String> FILE_FORMAT = createField("FILE_FORMAT", org.jooq.impl.SQLDataType.VARCHAR.length(10), this, "");

    /**
     * The column <code>information_schema.INNODB_SYS_TABLES.ROW_FORMAT</code>.
     */
    public final TableField<InnodbSysTablesRecord, String> ROW_FORMAT = createField("ROW_FORMAT", org.jooq.impl.SQLDataType.VARCHAR.length(12), this, "");

    /**
     * The column <code>information_schema.INNODB_SYS_TABLES.ZIP_PAGE_SIZE</code>.
     */
    public final TableField<InnodbSysTablesRecord, UInteger> ZIP_PAGE_SIZE = createField("ZIP_PAGE_SIZE", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.INTEGERUNSIGNED)), this, "");

    /**
     * The column <code>information_schema.INNODB_SYS_TABLES.SPACE_TYPE</code>.
     */
    public final TableField<InnodbSysTablesRecord, String> SPACE_TYPE = createField("SPACE_TYPE", org.jooq.impl.SQLDataType.VARCHAR.length(10), this, "");

    /**
     * Create a <code>information_schema.INNODB_SYS_TABLES</code> table reference
     */
    public InnodbSysTables() {
        this("INNODB_SYS_TABLES", null);
    }

    /**
     * Create an aliased <code>information_schema.INNODB_SYS_TABLES</code> table reference
     */
    public InnodbSysTables(String alias) {
        this(alias, INNODB_SYS_TABLES);
    }

    private InnodbSysTables(String alias, Table<InnodbSysTablesRecord> aliased) {
        this(alias, aliased, null);
    }

    private InnodbSysTables(String alias, Table<InnodbSysTablesRecord> aliased, Field<?>[] parameters) {
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
    public InnodbSysTables as(String alias) {
        return new InnodbSysTables(alias, this);
    }

    /**
     * Rename this table
     */
    public InnodbSysTables rename(String name) {
        return new InnodbSysTables(name, null);
    }
}
