/**
 * This class is generated by jOOQ
 */
package me.signatured.vpnguarddatabase.information_schema.tables.records;


import javax.annotation.Generated;

import me.signatured.vpnguarddatabase.information_schema.tables.OptimizerTrace;

import org.jooq.Field;
import org.jooq.Record4;
import org.jooq.Row4;
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
public class OptimizerTraceRecord extends TableRecordImpl<OptimizerTraceRecord> implements Record4<String, String, Integer, Byte> {

    private static final long serialVersionUID = 1584274431;

    /**
     * Setter for <code>information_schema.OPTIMIZER_TRACE.QUERY</code>.
     */
    public void setQuery(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>information_schema.OPTIMIZER_TRACE.QUERY</code>.
     */
    public String getQuery() {
        return (String) get(0);
    }

    /**
     * Setter for <code>information_schema.OPTIMIZER_TRACE.TRACE</code>.
     */
    public void setTrace(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>information_schema.OPTIMIZER_TRACE.TRACE</code>.
     */
    public String getTrace() {
        return (String) get(1);
    }

    /**
     * Setter for <code>information_schema.OPTIMIZER_TRACE.MISSING_BYTES_BEYOND_MAX_MEM_SIZE</code>.
     */
    public void setMissingBytesBeyondMaxMemSize(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>information_schema.OPTIMIZER_TRACE.MISSING_BYTES_BEYOND_MAX_MEM_SIZE</code>.
     */
    public Integer getMissingBytesBeyondMaxMemSize() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>information_schema.OPTIMIZER_TRACE.INSUFFICIENT_PRIVILEGES</code>.
     */
    public void setInsufficientPrivileges(Byte value) {
        set(3, value);
    }

    /**
     * Getter for <code>information_schema.OPTIMIZER_TRACE.INSUFFICIENT_PRIVILEGES</code>.
     */
    public Byte getInsufficientPrivileges() {
        return (Byte) get(3);
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<String, String, Integer, Byte> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<String, String, Integer, Byte> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return OptimizerTrace.OPTIMIZER_TRACE.QUERY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return OptimizerTrace.OPTIMIZER_TRACE.TRACE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return OptimizerTrace.OPTIMIZER_TRACE.MISSING_BYTES_BEYOND_MAX_MEM_SIZE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Byte> field4() {
        return OptimizerTrace.OPTIMIZER_TRACE.INSUFFICIENT_PRIVILEGES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getQuery();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getTrace();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getMissingBytesBeyondMaxMemSize();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte value4() {
        return getInsufficientPrivileges();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OptimizerTraceRecord value1(String value) {
        setQuery(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OptimizerTraceRecord value2(String value) {
        setTrace(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OptimizerTraceRecord value3(Integer value) {
        setMissingBytesBeyondMaxMemSize(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OptimizerTraceRecord value4(Byte value) {
        setInsufficientPrivileges(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OptimizerTraceRecord values(String value1, String value2, Integer value3, Byte value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached OptimizerTraceRecord
     */
    public OptimizerTraceRecord() {
        super(OptimizerTrace.OPTIMIZER_TRACE);
    }

    /**
     * Create a detached, initialised OptimizerTraceRecord
     */
    public OptimizerTraceRecord(String query, String trace, Integer missingBytesBeyondMaxMemSize, Byte insufficientPrivileges) {
        super(OptimizerTrace.OPTIMIZER_TRACE);

        set(0, query);
        set(1, trace);
        set(2, missingBytesBeyondMaxMemSize);
        set(3, insufficientPrivileges);
    }
}
