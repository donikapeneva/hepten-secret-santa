/*
 * This file is generated by jOOQ.
 */
package com.dg.heptensecretsanta.tables;


import com.dg.heptensecretsanta.Keys;
import com.dg.heptensecretsanta.Public;
import com.dg.heptensecretsanta.tables.records.RoomRecord;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function8;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row8;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Room extends TableImpl<RoomRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.room</code>
     */
    public static final Room ROOM = new Room();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<RoomRecord> getRecordType() {
        return RoomRecord.class;
    }

    /**
     * The column <code>public.room.id</code>.
     */
    public final TableField<RoomRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.room.room_name</code>.
     */
    public final TableField<RoomRecord, String> ROOM_NAME = createField(DSL.name("room_name"), SQLDataType.VARCHAR(256).nullable(false), this, "");

    /**
     * The column <code>public.room.pass_code</code>.
     */
    public final TableField<RoomRecord, String> PASS_CODE = createField(DSL.name("pass_code"), SQLDataType.VARCHAR(256).nullable(false), this, "");

    /**
     * The column <code>public.room.user_id</code>.
     */
    public final TableField<RoomRecord, Integer> USER_ID = createField(DSL.name("user_id"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.room.budget</code>.
     */
    public final TableField<RoomRecord, String> BUDGET = createField(DSL.name("budget"), SQLDataType.VARCHAR(256).nullable(false), this, "");

    /**
     * The column <code>public.room.nickname_theme_id</code>.
     */
    public final TableField<RoomRecord, Integer> NICKNAME_THEME_ID = createField(DSL.name("nickname_theme_id"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.room.status</code>.
     */
    public final TableField<RoomRecord, String> STATUS = createField(DSL.name("status"), SQLDataType.VARCHAR(256).nullable(false), this, "");

    /**
     * The column <code>public.room.reveal</code>.
     */
    public final TableField<RoomRecord, Boolean> REVEAL = createField(DSL.name("reveal"), SQLDataType.BOOLEAN, this, "");

    private Room(Name alias, Table<RoomRecord> aliased) {
        this(alias, aliased, null);
    }

    private Room(Name alias, Table<RoomRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.room</code> table reference
     */
    public Room(String alias) {
        this(DSL.name(alias), ROOM);
    }

    /**
     * Create an aliased <code>public.room</code> table reference
     */
    public Room(Name alias) {
        this(alias, ROOM);
    }

    /**
     * Create a <code>public.room</code> table reference
     */
    public Room() {
        this(DSL.name("room"), null);
    }

    public <O extends Record> Room(Table<O> child, ForeignKey<O, RoomRecord> key) {
        super(child, key, ROOM);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public Identity<RoomRecord, Integer> getIdentity() {
        return (Identity<RoomRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<RoomRecord> getPrimaryKey() {
        return Keys.ROOM_PKEY;
    }

    @Override
    public List<ForeignKey<RoomRecord, ?>> getReferences() {
        return Arrays.asList(Keys.ROOM__USER_FK, Keys.ROOM__NICKNAME_THEME_FK);
    }

    private transient User _user;
    private transient NicknameTheme _nicknameTheme;

    /**
     * Get the implicit join path to the <code>public.user</code> table.
     */
    public User user() {
        if (_user == null)
            _user = new User(this, Keys.ROOM__USER_FK);

        return _user;
    }

    /**
     * Get the implicit join path to the <code>public.nickname_theme</code>
     * table.
     */
    public NicknameTheme nicknameTheme() {
        if (_nicknameTheme == null)
            _nicknameTheme = new NicknameTheme(this, Keys.ROOM__NICKNAME_THEME_FK);

        return _nicknameTheme;
    }

    @Override
    public Room as(String alias) {
        return new Room(DSL.name(alias), this);
    }

    @Override
    public Room as(Name alias) {
        return new Room(alias, this);
    }

    @Override
    public Room as(Table<?> alias) {
        return new Room(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Room rename(String name) {
        return new Room(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Room rename(Name name) {
        return new Room(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Room rename(Table<?> name) {
        return new Room(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row8 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row8<Integer, String, String, Integer, String, Integer, String, Boolean> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function8<? super Integer, ? super String, ? super String, ? super Integer, ? super String, ? super Integer, ? super String, ? super Boolean, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function8<? super Integer, ? super String, ? super String, ? super Integer, ? super String, ? super Integer, ? super String, ? super Boolean, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
