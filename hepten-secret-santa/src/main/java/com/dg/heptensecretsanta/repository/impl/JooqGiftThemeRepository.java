package com.dg.heptensecretsanta.repository.impl;

import com.dg.heptensecretsanta.Tables;
import com.dg.heptensecretsanta.repository.GiftThemeRepository;
import com.dg.heptensecretsanta.tables.pojos.GiftTheme;
import lombok.AllArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.tools.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.Optional;

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
}
