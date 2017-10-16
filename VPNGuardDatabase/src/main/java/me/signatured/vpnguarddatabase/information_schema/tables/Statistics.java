/**
 * This class is generated by jOOQ
 */
package me.signatured.vpnguarddatabase.information_schema.tables;


import javax.annotation.Generated;

import me.signatured.vpnguarddatabase.information_schema.InformationSchema;
import me.signatured.vpnguarddatabase.information_schema.tables.records.StatisticsRecord;

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
public class Statistics extends TableImpl<StatisticsRecord> {

    private static final long serialVersionUID = -1343252538;

    /**
     * The reference instance of <code>information_schema.STATISTICS</code>
     */
    public static final Statistics STATISTICS = new Statistics();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<StatisticsRecord> getRecordType() {
        return StatisticsRecord.class;
    }

    /**
     * The column <code>information_schema.STATISTICS.TABLE_CATALOG</code>.
     */
    public final TableField<StatisticsRecord, String> TABLE_CATALOG = createField("TABLE_CATALOG", org.jooq.impl.SQLDataType.VARCHAR.length(512).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>information_schema.STATISTICS.TABLE_SCHEMA</code>.
     */
    public final TableField<StatisticsRecord, String> TABLE_SCHEMA = createField("TABLE_SCHEMA", org.jooq.impl.SQLDataType.VARCHAR.length(64).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>information_schema.STATISTICS.TABLE_NAME</code>.
     */
    public final TableField<StatisticsRecord, String> TABLE_NAME = createField("TABLE_NAME", org.jooq.impl.SQLDataType.VARCHAR.length(64).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>information_schema.STATISTICS.NON_UNIQUE</code>.
     */
    public final TableField<StatisticsRecord, Long> NON_UNIQUE = createField("NON_UNIQUE", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>information_schema.STATISTICS.INDEX_SCHEMA</code>.
     */
    public final TableField<StatisticsRecord, String> INDEX_SCHEMA = createField("INDEX_SCHEMA", org.jooq.impl.SQLDataType.VARCHAR.length(64).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>information_schema.STATISTICS.INDEX_NAME</code>.
     */
    public final TableField<StatisticsRecord, String> INDEX_NAME = createField("INDEX_NAME", org.jooq.impl.SQLDataType.VARCHAR.length(64).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>information_schema.STATISTICS.SEQ_IN_INDEX</code>.
     */
    public final TableField<StatisticsRecord, Long> SEQ_IN_INDEX = createField("SEQ_IN_INDEX", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>information_schema.STATISTICS.COLUMN_NAME</code>.
     */
    public final TableField<StatisticsRecord, String> COLUMN_NAME = createField("COLUMN_NAME", org.jooq.impl.SQLDataType.VARCHAR.length(64).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>information_schema.STATISTICS.COLLATION</code>.
     */
    public final TableField<StatisticsRecord, String> COLLATION = createField("COLLATION", org.jooq.impl.SQLDataType.VARCHAR.length(1), this, "");

    /**
     * The column <code>information_schema.STATISTICS.CARDINALITY</code>.
     */
    public final TableField<StatisticsRecord, Long> CARDINALITY = createField("CARDINALITY", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>information_schema.STATISTICS.SUB_PART</code>.
     */
    public final TableField<StatisticsRecord, Long> SUB_PART = createField("SUB_PART", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>information_schema.STATISTICS.PACKED</code>.
     */
    public final TableField<StatisticsRecord, String> PACKED = createField("PACKED", org.jooq.impl.SQLDataType.VARCHAR.length(10), this, "");

    /**
     * The column <code>information_schema.STATISTICS.NULLABLE</code>.
     */
    public final TableField<StatisticsRecord, String> NULLABLE = createField("NULLABLE", org.jooq.impl.SQLDataType.VARCHAR.length(3).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>information_schema.STATISTICS.INDEX_TYPE</code>.
     */
    public final TableField<StatisticsRecord, String> INDEX_TYPE = createField("INDEX_TYPE", org.jooq.impl.SQLDataType.VARCHAR.length(16).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>information_schema.STATISTICS.COMMENT</code>.
     */
    public final TableField<StatisticsRecord, String> COMMENT = createField("COMMENT", org.jooq.impl.SQLDataType.VARCHAR.length(16), this, "");

    /**
     * The column <code>information_schema.STATISTICS.INDEX_COMMENT</code>.
     */
    public final TableField<StatisticsRecord, String> INDEX_COMMENT = createField("INDEX_COMMENT", org.jooq.impl.SQLDataType.VARCHAR.length(1024).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * Create a <code>information_schema.STATISTICS</code> table reference
     */
    public Statistics() {
        this("STATISTICS", null);
    }

    /**
     * Create an aliased <code>information_schema.STATISTICS</code> table reference
     */
    public Statistics(String alias) {
        this(alias, STATISTICS);
    }

    private Statistics(String alias, Table<StatisticsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Statistics(String alias, Table<StatisticsRecord> aliased, Field<?>[] parameters) {
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
    public Statistics as(String alias) {
        return new Statistics(alias, this);
    }

    /**
     * Rename this table
     */
    public Statistics rename(String name) {
        return new Statistics(name, null);
    }
}
