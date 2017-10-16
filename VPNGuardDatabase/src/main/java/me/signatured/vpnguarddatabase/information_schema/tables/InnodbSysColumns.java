/**
 * This class is generated by jOOQ
 */
package me.signatured.vpnguarddatabase.information_schema.tables;


import javax.annotation.Generated;

import me.signatured.vpnguarddatabase.information_schema.InformationSchema;
import me.signatured.vpnguarddatabase.information_schema.tables.records.InnodbSysColumnsRecord;

import org.jooq.Field;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.TableImpl;
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
public class InnodbSysColumns extends TableImpl<InnodbSysColumnsRecord> {

    private static final long serialVersionUID = 1275608791;

    /**
     * The reference instance of <code>information_schema.INNODB_SYS_COLUMNS</code>
     */
    public static final InnodbSysColumns INNODB_SYS_COLUMNS = new InnodbSysColumns();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<InnodbSysColumnsRecord> getRecordType() {
        return InnodbSysColumnsRecord.class;
    }

    /**
     * The column <code>information_schema.INNODB_SYS_COLUMNS.TABLE_ID</code>.
     */
    public final TableField<InnodbSysColumnsRecord, ULong> TABLE_ID = createField("TABLE_ID", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.BIGINTUNSIGNED)), this, "");

    /**
     * The column <code>information_schema.INNODB_SYS_COLUMNS.NAME</code>.
     */
    public final TableField<InnodbSysColumnsRecord, String> NAME = createField("NAME", org.jooq.impl.SQLDataType.VARCHAR.length(193).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>information_schema.INNODB_SYS_COLUMNS.POS</code>.
     */
    public final TableField<InnodbSysColumnsRecord, ULong> POS = createField("POS", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.BIGINTUNSIGNED)), this, "");

    /**
     * The column <code>information_schema.INNODB_SYS_COLUMNS.MTYPE</code>.
     */
    public final TableField<InnodbSysColumnsRecord, Integer> MTYPE = createField("MTYPE", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>information_schema.INNODB_SYS_COLUMNS.PRTYPE</code>.
     */
    public final TableField<InnodbSysColumnsRecord, Integer> PRTYPE = createField("PRTYPE", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>information_schema.INNODB_SYS_COLUMNS.LEN</code>.
     */
    public final TableField<InnodbSysColumnsRecord, Integer> LEN = createField("LEN", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * Create a <code>information_schema.INNODB_SYS_COLUMNS</code> table reference
     */
    public InnodbSysColumns() {
        this("INNODB_SYS_COLUMNS", null);
    }

    /**
     * Create an aliased <code>information_schema.INNODB_SYS_COLUMNS</code> table reference
     */
    public InnodbSysColumns(String alias) {
        this(alias, INNODB_SYS_COLUMNS);
    }

    private InnodbSysColumns(String alias, Table<InnodbSysColumnsRecord> aliased) {
        this(alias, aliased, null);
    }

    private InnodbSysColumns(String alias, Table<InnodbSysColumnsRecord> aliased, Field<?>[] parameters) {
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
    public InnodbSysColumns as(String alias) {
        return new InnodbSysColumns(alias, this);
    }

    /**
     * Rename this table
     */
    public InnodbSysColumns rename(String name) {
        return new InnodbSysColumns(name, null);
    }
}
