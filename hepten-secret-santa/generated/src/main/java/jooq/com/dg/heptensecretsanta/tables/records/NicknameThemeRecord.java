/*
 * This file is generated by jOOQ.
 */
package com.dg.heptensecretsanta.tables.records;


import com.dg.heptensecretsanta.tables.NicknameTheme;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class NicknameThemeRecord extends UpdatableRecordImpl<NicknameThemeRecord> implements Record3<Integer, String, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.nickname_theme.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.nickname_theme.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.nickname_theme.category</code>.
     */
    public void setCategory(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.nickname_theme.category</code>.
     */
    public String getCategory() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.nickname_theme.nicknames</code>.
     */
    public void setNicknames(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.nickname_theme.nicknames</code>.
     */
    public String getNicknames() {
        return (String) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<Integer, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<Integer, String, String> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return NicknameTheme.NICKNAME_THEME.ID;
    }

    @Override
    public Field<String> field2() {
        return NicknameTheme.NICKNAME_THEME.CATEGORY;
    }

    @Override
    public Field<String> field3() {
        return NicknameTheme.NICKNAME_THEME.NICKNAMES;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getCategory();
    }

    @Override
    public String component3() {
        return getNicknames();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getCategory();
    }

    @Override
    public String value3() {
        return getNicknames();
    }

    @Override
    public NicknameThemeRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public NicknameThemeRecord value2(String value) {
        setCategory(value);
        return this;
    }

    @Override
    public NicknameThemeRecord value3(String value) {
        setNicknames(value);
        return this;
    }

    @Override
    public NicknameThemeRecord values(Integer value1, String value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached NicknameThemeRecord
     */
    public NicknameThemeRecord() {
        super(NicknameTheme.NICKNAME_THEME);
    }

    /**
     * Create a detached, initialised NicknameThemeRecord
     */
    public NicknameThemeRecord(Integer id, String category, String nicknames) {
        super(NicknameTheme.NICKNAME_THEME);

        setId(id);
        setCategory(category);
        setNicknames(nicknames);
    }

    /**
     * Create a detached, initialised NicknameThemeRecord
     */
    public NicknameThemeRecord(com.dg.heptensecretsanta.tables.pojos.NicknameTheme value) {
        super(NicknameTheme.NICKNAME_THEME);

        if (value != null) {
            setId(value.getId());
            setCategory(value.getCategory());
            setNicknames(value.getNicknames());
        }
    }
}
