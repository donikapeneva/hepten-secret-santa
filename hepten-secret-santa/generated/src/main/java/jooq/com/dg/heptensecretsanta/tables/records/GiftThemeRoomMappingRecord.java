/*
 * This file is generated by jOOQ.
 */
package com.dg.heptensecretsanta.tables.records;


import com.dg.heptensecretsanta.tables.GiftThemeRoomMapping;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class GiftThemeRoomMappingRecord extends UpdatableRecordImpl<GiftThemeRoomMappingRecord> implements Record2<Integer, Integer> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.gift_theme_room_mapping.gift_theme_id</code>.
     */
    public void setGiftThemeId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.gift_theme_room_mapping.gift_theme_id</code>.
     */
    public Integer getGiftThemeId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.gift_theme_room_mapping.room_id</code>.
     */
    public void setRoomId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.gift_theme_room_mapping.room_id</code>.
     */
    public Integer getRoomId() {
        return (Integer) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record2<Integer, Integer> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<Integer, Integer> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<Integer, Integer> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return GiftThemeRoomMapping.GIFT_THEME_ROOM_MAPPING.GIFT_THEME_ID;
    }

    @Override
    public Field<Integer> field2() {
        return GiftThemeRoomMapping.GIFT_THEME_ROOM_MAPPING.ROOM_ID;
    }

    @Override
    public Integer component1() {
        return getGiftThemeId();
    }

    @Override
    public Integer component2() {
        return getRoomId();
    }

    @Override
    public Integer value1() {
        return getGiftThemeId();
    }

    @Override
    public Integer value2() {
        return getRoomId();
    }

    @Override
    public GiftThemeRoomMappingRecord value1(Integer value) {
        setGiftThemeId(value);
        return this;
    }

    @Override
    public GiftThemeRoomMappingRecord value2(Integer value) {
        setRoomId(value);
        return this;
    }

    @Override
    public GiftThemeRoomMappingRecord values(Integer value1, Integer value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached GiftThemeRoomMappingRecord
     */
    public GiftThemeRoomMappingRecord() {
        super(GiftThemeRoomMapping.GIFT_THEME_ROOM_MAPPING);
    }

    /**
     * Create a detached, initialised GiftThemeRoomMappingRecord
     */
    public GiftThemeRoomMappingRecord(Integer giftThemeId, Integer roomId) {
        super(GiftThemeRoomMapping.GIFT_THEME_ROOM_MAPPING);

        setGiftThemeId(giftThemeId);
        setRoomId(roomId);
    }

    /**
     * Create a detached, initialised GiftThemeRoomMappingRecord
     */
    public GiftThemeRoomMappingRecord(com.dg.heptensecretsanta.tables.pojos.GiftThemeRoomMapping value) {
        super(GiftThemeRoomMapping.GIFT_THEME_ROOM_MAPPING);

        if (value != null) {
            setGiftThemeId(value.getGiftThemeId());
            setRoomId(value.getRoomId());
        }
    }
}
