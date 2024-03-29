/**
 * This class is generated by jOOQ
 */
package me.signatured.vpnguarddatabase.information_schema.tables.records;


import javax.annotation.Generated;

import me.signatured.vpnguarddatabase.information_schema.tables.Engines;

import org.jooq.Field;
import org.jooq.Record6;
import org.jooq.Row6;
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
public class EnginesRecord extends TableRecordImpl<EnginesRecord> implements Record6<String, String, String, String, String, String> {

    private static final long serialVersionUID = -1393302810;

    /**
     * Setter for <code>information_schema.ENGINES.ENGINE</code>.
     */
    public void setEngine(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>information_schema.ENGINES.ENGINE</code>.
     */
    public String getEngine() {
        return (String) get(0);
    }

    /**
     * Setter for <code>information_schema.ENGINES.SUPPORT</code>.
     */
    public void setSupport(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>information_schema.ENGINES.SUPPORT</code>.
     */
    public String getSupport() {
        return (String) get(1);
    }

    /**
     * Setter for <code>information_schema.ENGINES.COMMENT</code>.
     */
    public void setComment(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>information_schema.ENGINES.COMMENT</code>.
     */
    public String getComment() {
        return (String) get(2);
    }

    /**
     * Setter for <code>information_schema.ENGINES.TRANSACTIONS</code>.
     */
    public void setTransactions(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>information_schema.ENGINES.TRANSACTIONS</code>.
     */
    public String getTransactions() {
        return (String) get(3);
    }

    /**
     * Setter for <code>information_schema.ENGINES.XA</code>.
     */
    public void setXa(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>information_schema.ENGINES.XA</code>.
     */
    public String getXa() {
        return (String) get(4);
    }

    /**
     * Setter for <code>information_schema.ENGINES.SAVEPOINTS</code>.
     */
    public void setSavepoints(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>information_schema.ENGINES.SAVEPOINTS</code>.
     */
    public String getSavepoints() {
        return (String) get(5);
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<String, String, String, String, String, String> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<String, String, String, String, String, String> valuesRow() {
        return (Row6) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return Engines.ENGINES.ENGINE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Engines.ENGINES.SUPPORT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Engines.ENGINES.COMMENT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Engines.ENGINES.TRANSACTIONS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Engines.ENGINES.XA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return Engines.ENGINES.SAVEPOINTS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getEngine();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getSupport();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getComment();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getTransactions();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getXa();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getSavepoints();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EnginesRecord value1(String value) {
        setEngine(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EnginesRecord value2(String value) {
        setSupport(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EnginesRecord value3(String value) {
        setComment(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EnginesRecord value4(String value) {
        setTransactions(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EnginesRecord value5(String value) {
        setXa(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EnginesRecord value6(String value) {
        setSavepoints(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EnginesRecord values(String value1, String value2, String value3, String value4, String value5, String value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached EnginesRecord
     */
    public EnginesRecord() {
        super(Engines.ENGINES);
    }

    /**
     * Create a detached, initialised EnginesRecord
     */
    public EnginesRecord(String engine, String support, String comment, String transactions, String xa, String savepoints) {
        super(Engines.ENGINES);

        set(0, engine);
        set(1, support);
        set(2, comment);
        set(3, transactions);
        set(4, xa);
        set(5, savepoints);
    }
}
