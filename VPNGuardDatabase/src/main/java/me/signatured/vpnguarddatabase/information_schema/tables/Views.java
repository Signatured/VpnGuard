/**
 * This class is generated by jOOQ
 */
package me.signatured.vpnguarddatabase.information_schema.tables;


import javax.annotation.Generated;

import me.signatured.vpnguarddatabase.information_schema.InformationSchema;
import me.signatured.vpnguarddatabase.information_schema.tables.records.ViewsRecord;

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
public class Views extends TableImpl<ViewsRecord> {

    private static final long serialVersionUID = -797507573;

    /**
     * The reference instance of <code>information_schema.VIEWS</code>
     */
    public static final Views VIEWS = new Views();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ViewsRecord> getRecordType() {
        return ViewsRecord.class;
    }

    /**
     * The column <code>information_schema.VIEWS.TABLE_CATALOG</code>.
     */
    public final TableField<ViewsRecord, String> TABLE_CATALOG = createField("TABLE_CATALOG", org.jooq.impl.SQLDataType.VARCHAR.length(512).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>information_schema.VIEWS.TABLE_SCHEMA</code>.
     */
    public final TableField<ViewsRecord, String> TABLE_SCHEMA = createField("TABLE_SCHEMA", org.jooq.impl.SQLDataType.VARCHAR.length(64).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>information_schema.VIEWS.TABLE_NAME</code>.
     */
    public final TableField<ViewsRecord, String> TABLE_NAME = createField("TABLE_NAME", org.jooq.impl.SQLDataType.VARCHAR.length(64).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>information_schema.VIEWS.VIEW_DEFINITION</code>.
     */
    public final TableField<ViewsRecord, String> VIEW_DEFINITION = createField("VIEW_DEFINITION", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>information_schema.VIEWS.CHECK_OPTION</code>.
     */
    public final TableField<ViewsRecord, String> CHECK_OPTION = createField("CHECK_OPTION", org.jooq.impl.SQLDataType.VARCHAR.length(8).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>information_schema.VIEWS.IS_UPDATABLE</code>.
     */
    public final TableField<ViewsRecord, String> IS_UPDATABLE = createField("IS_UPDATABLE", org.jooq.impl.SQLDataType.VARCHAR.length(3).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>information_schema.VIEWS.DEFINER</code>.
     */
    public final TableField<ViewsRecord, String> DEFINER = createField("DEFINER", org.jooq.impl.SQLDataType.VARCHAR.length(93).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>information_schema.VIEWS.SECURITY_TYPE</code>.
     */
    public final TableField<ViewsRecord, String> SECURITY_TYPE = createField("SECURITY_TYPE", org.jooq.impl.SQLDataType.VARCHAR.length(7).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>information_schema.VIEWS.CHARACTER_SET_CLIENT</code>.
     */
    public final TableField<ViewsRecord, String> CHARACTER_SET_CLIENT = createField("CHARACTER_SET_CLIENT", org.jooq.impl.SQLDataType.VARCHAR.length(32).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>information_schema.VIEWS.COLLATION_CONNECTION</code>.
     */
    public final TableField<ViewsRecord, String> COLLATION_CONNECTION = createField("COLLATION_CONNECTION", org.jooq.impl.SQLDataType.VARCHAR.length(32).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * Create a <code>information_schema.VIEWS</code> table reference
     */
    public Views() {
        this("VIEWS", null);
    }

    /**
     * Create an aliased <code>information_schema.VIEWS</code> table reference
     */
    public Views(String alias) {
        this(alias, VIEWS);
    }

    private Views(String alias, Table<ViewsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Views(String alias, Table<ViewsRecord> aliased, Field<?>[] parameters) {
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
    public Views as(String alias) {
        return new Views(alias, this);
    }

    /**
     * Rename this table
     */
    public Views rename(String name) {
        return new Views(name, null);
    }
}
