package com.dg.heptensecretsanta.repository.impl;

import com.dg.heptensecretsanta.Tables;
import com.dg.heptensecretsanta.repository.GiftThemeRepository;
import com.dg.heptensecretsanta.tables.pojos.GiftTheme;
import com.dg.heptensecretsanta.tables.pojos.GiftThemeUserMapping;
import com.dg.heptensecretsanta.tables.pojos.User;
import lombok.AllArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.tools.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.dg.heptensecretsanta.Tables.ROOM_USER_MAPPING;
import static com.dg.heptensecretsanta.Tables.USER;

@Repository
@AllArgsConstructor
public class JooqGiftThemeRepository implements GiftThemeRepository {

    private final DSLContext create;

    @Override
    public Optional<GiftTheme> fetchGiftThemeByCategory(String category) {
        if (StringUtils.isBlank(category)) {
            return Optional.empty();
        }

        return create.selectFrom(Tables.GIFT_THEME)
                .where(Tables.GIFT_THEME.CATEGORY.eq(category))
                .fetchOptionalInto(GiftTheme.class);
    }

    @Override
    public Optional<List<GiftTheme>> fetchGiftThemeByRoomId(Integer roomId) {
        List<GiftTheme> records = create.selectFrom(Tables.GIFT_THEME
            .join(Tables.GIFT_THEME_ROOM_MAPPING)
            .on(Tables.GIFT_THEME.ID.eq(Tables.GIFT_THEME_ROOM_MAPPING.GIFT_THEME_ID)))
                .where(Tables.GIFT_THEME_ROOM_MAPPING.ROOM_ID.eq(roomId))
                .fetchInto(GiftTheme.class);

        return Optional.ofNullable(records);
    }

    @Override
    public Optional<List<GiftThemeUserMapping>> fetchGiftThemeByRoomAndUserMapping(Integer roomId, Integer userId) {
        List<GiftThemeUserMapping> records = create.selectFrom(Tables.GIFT_THEME_USER_MAPPING)
                .where(Tables.GIFT_THEME_USER_MAPPING.ROOM_ID.eq(roomId))
                .and(Tables.GIFT_THEME_USER_MAPPING.USER_ID.eq(userId))
                .fetchInto(GiftThemeUserMapping.class);

        return Optional.ofNullable(records);
    }

    @Override
    public void insertGiftThemeUserMapping(Integer userId, Integer roomId, Integer categoryId, String giftAttribute) {
        create.insertInto(Tables.GIFT_THEME_USER_MAPPING)
                .set(Tables.GIFT_THEME_USER_MAPPING.USER_ID, userId)
                .set(Tables.GIFT_THEME_USER_MAPPING.ROOM_ID, roomId)
                .set(Tables.GIFT_THEME_USER_MAPPING.GIFT_THEME_ID, categoryId)
                .set(Tables.GIFT_THEME_USER_MAPPING.GIFT_ATTRIBUTE, giftAttribute)
                .execute();
    }
}
