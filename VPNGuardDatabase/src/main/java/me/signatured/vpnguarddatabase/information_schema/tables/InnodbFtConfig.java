/**
 * This class is generated by jOOQ
 */
package me.signatured.vpnguarddatabase.information_schema.tables;


import javax.annotation.Generated;

import me.signatured.vpnguarddatabase.information_schema.InformationSchema;
import me.signatured.vpnguarddatabase.information_schema.tables.records.InnodbFtConfigRecord;

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
public class InnodbFtConfig extends TableImpl<InnodbFtConfigRecord> {

    private static final long serialVersionUID = 1051376898;

    /**
     * The reference instance of <code>information_schema.INNODB_FT_CONFIG</code>
     */
    public static final InnodbFtConfig INNODB_FT_CONFIG = new InnodbFtConfig();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<InnodbFtConfigRecord> getRecordType() {
        return InnodbFtConfigRecord.class;
    }

    /**
     * The column <code>information_schema.INNODB_FT_CONFIG.KEY</code>.
     */
    public final TableField<InnodbFtConfigRecord, String> KEY = createField("KEY", org.jooq.impl.SQLDataType.VARCHAR.length(193).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>information_schema.INNODB_FT_CONFIG.VALUE</code>.
     */
    public final TableField<InnodbFtConfigRecord, String> VALUE = createField("VALUE", org.jooq.impl.SQLDataType.VARCHAR.length(193).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * Create a <code>information_schema.INNODB_FT_CONFIG</code> table reference
     */
    public InnodbFtConfig() {
        this("INNODB_FT_CONFIG", null);
    }

    /**
     * Create an aliased <code>information_schema.INNODB_FT_CONFIG</code> table reference
     */
    public InnodbFtConfig(String alias) {
        this(alias, INNODB_FT_CONFIG);
    }

    private InnodbFtConfig(String alias, Table<InnodbFtConfigRecord> aliased) {
        this(alias, aliased, null);
    }

    private InnodbFtConfig(String alias, Table<InnodbFtConfigRecord> aliased, Field<?>[] parameters) {
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
    public InnodbFtConfig as(String alias) {
        return new InnodbFtConfig(alias, this);
    }

    /**
     * Rename this table
     */
    public InnodbFtConfig rename(String name) {
        return new InnodbFtConfig(name, null);
    }
}
