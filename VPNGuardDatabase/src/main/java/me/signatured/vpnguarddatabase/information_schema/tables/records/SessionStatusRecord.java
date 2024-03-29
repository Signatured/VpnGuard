/**
 * This class is generated by jOOQ
 */
package me.signatured.vpnguarddatabase.information_schema.tables.records;


import javax.annotation.Generated;

import me.signatured.vpnguarddatabase.information_schema.tables.SessionStatus;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.TableRecordImpl;


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
public class SessionStatusRecord extends TableRecordImpl<SessionStatusRecord> implements Record2<String, String> {

    private static final long serialVersionUID = 1619320742;

    /**
     * Setter for <code>information_schema.SESSION_STATUS.VARIABLE_NAME</code>.
     */
    public void setVariableName(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>information_schema.SESSION_STATUS.VARIABLE_NAME</code>.
     */
    public String getVariableName() {
        return (String) get(0);
    }

    /**
     * Setter for <code>information_schema.SESSION_STATUS.VARIABLE_VALUE</code>.
     */
    public void setVariableValue(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>information_schema.SESSION_STATUS.VARIABLE_VALUE</code>.
     */
    public String getVariableValue() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<String, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<String, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return SessionStatus.SESSION_STATUS.VARIABLE_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return SessionStatus.SESSION_STATUS.VARIABLE_VALUE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getVariableName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getVariableValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SessionStatusRecord value1(String value) {
        setVariableName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SessionStatusRecord value2(String value) {
        setVariableValue(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SessionStatusRecord values(String value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SessionStatusRecord
     */
    public SessionStatusRecord() {
        super(SessionStatus.SESSION_STATUS);
    }

    /**
     * Create a detached, initialised SessionStatusRecord
     */
    public SessionStatusRecord(String variableName, String variableValue) {
        super(SessionStatus.SESSION_STATUS);

        set(0, variableName);
        set(1, variableValue);
    }
}
