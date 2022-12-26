/*
 * This file is generated by jOOQ.
 */
package com.dg.heptensecretsanta;


import com.dg.heptensecretsanta.tables.FlywaySchemaHistory;
import com.dg.heptensecretsanta.tables.GiftTheme;
import com.dg.heptensecretsanta.tables.GiftThemeRoomMapping;
import com.dg.heptensecretsanta.tables.GiftThemeUserMapping;
import com.dg.heptensecretsanta.tables.NicknameTheme;
import com.dg.heptensecretsanta.tables.NicknameUserMapping;
import com.dg.heptensecretsanta.tables.Room;
import com.dg.heptensecretsanta.tables.RoomUserMapping;
import com.dg.heptensecretsanta.tables.User;

import java.util.Arrays;
import java.util.List;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Public extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public</code>
     */
    public static final Public PUBLIC = new Public();

    /**
     * The table <code>public.flyway_schema_history</code>.
     */
    public final FlywaySchemaHistory FLYWAY_SCHEMA_HISTORY = FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY;

    /**
     * The table <code>public.gift_theme</code>.
     */
    public final GiftTheme GIFT_THEME = GiftTheme.GIFT_THEME;

    /**
     * The table <code>public.gift_theme_room_mapping</code>.
     */
    public final GiftThemeRoomMapping GIFT_THEME_ROOM_MAPPING = GiftThemeRoomMapping.GIFT_THEME_ROOM_MAPPING;

    /**
     * The table <code>public.gift_theme_user_mapping</code>.
     */
    public final GiftThemeUserMapping GIFT_THEME_USER_MAPPING = GiftThemeUserMapping.GIFT_THEME_USER_MAPPING;

    /**
     * The table <code>public.nickname_theme</code>.
     */
    public final NicknameTheme NICKNAME_THEME = NicknameTheme.NICKNAME_THEME;

    /**
     * The table <code>public.nickname_user_mapping</code>.
     */
    public final NicknameUserMapping NICKNAME_USER_MAPPING = NicknameUserMapping.NICKNAME_USER_MAPPING;

    /**
     * The table <code>public.room</code>.
     */
    public final Room ROOM = Room.ROOM;

    /**
     * The table <code>public.room_user_mapping</code>.
     */
    public final RoomUserMapping ROOM_USER_MAPPING = RoomUserMapping.ROOM_USER_MAPPING;

    /**
     * The table <code>public.user</code>.
     */
    public final User USER = User.USER;

    /**
     * No further instances allowed
     */
    private Public() {
        super("public", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.asList(
            FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY,
            GiftTheme.GIFT_THEME,
            GiftThemeRoomMapping.GIFT_THEME_ROOM_MAPPING,
            GiftThemeUserMapping.GIFT_THEME_USER_MAPPING,
            NicknameTheme.NICKNAME_THEME,
            NicknameUserMapping.NICKNAME_USER_MAPPING,
            Room.ROOM,
            RoomUserMapping.ROOM_USER_MAPPING,
            User.USER
        );
    }
}