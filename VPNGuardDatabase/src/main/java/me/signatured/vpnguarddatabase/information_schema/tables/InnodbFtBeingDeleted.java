/**
 * This class is generated by jOOQ
 */
package me.signatured.vpnguarddatabase.information_schema.tables;


import javax.annotation.Generated;

import me.signatured.vpnguarddatabase.information_schema.InformationSchema;
import me.signatured.vpnguarddatabase.information_schema.tables.records.InnodbFtBeingDeletedRecord;

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
public class InnodbFtBeingDeleted extends TableImpl<InnodbFtBeingDeletedRecord> {

    private static final long serialVersionUID = -1761055772;

    /**
     * The reference instance of <code>information_schema.INNODB_FT_BEING_DELETED</code>
     */
    public static final InnodbFtBeingDeleted INNODB_FT_BEING_DELETED = new InnodbFtBeingDeleted();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<InnodbFtBeingDeletedRecord> getRecordType() {
        return InnodbFtBeingDeletedRecord.class;
    }

    /**
     * The column <code>information_schema.INNODB_FT_BEING_DELETED.DOC_ID</code>.
     */
    public final TableField<InnodbFtBeingDeletedRecord, ULong> DOC_ID = createField("DOC_ID", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.BIGINTUNSIGNED)), this, "");

    /**
     * Create a <code>information_schema.INNODB_FT_BEING_DELETED</code> table reference
     */
    public InnodbFtBeingDeleted() {
        this("INNODB_FT_BEING_DELETED", null);
    }

    /**
     * Create an aliased <code>information_schema.INNODB_FT_BEING_DELETED</code> table reference
     */
    public InnodbFtBeingDeleted(String alias) {
        this(alias, INNODB_FT_BEING_DELETED);
    }

    private InnodbFtBeingDeleted(String alias, Table<InnodbFtBeingDeletedRecord> aliased) {
        this(alias, aliased, null);
    }

    private InnodbFtBeingDeleted(String alias, Table<InnodbFtBeingDeletedRecord> aliased, Field<?>[] parameters) {
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
    public InnodbFtBeingDeleted as(String alias) {
        return new InnodbFtBeingDeleted(alias, this);
    }

    /**
     * Rename this table
     */
    public InnodbFtBeingDeleted rename(String name) {
        return new InnodbFtBeingDeleted(name, null);
    }
}
