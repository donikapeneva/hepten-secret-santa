package com.dg.heptensecretsanta.repository.impl;

import com.dg.heptensecretsanta.Tables;
import com.dg.heptensecretsanta.repository.NicknameThemeRepository;
import com.dg.heptensecretsanta.tables.pojos.NicknameTheme;
import lombok.AllArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.tools.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class JooqNicknameThemeRepository implements NicknameThemeRepository {

    private final DSLContext create;

    @Override
    public Optional<NicknameTheme> fetchNicknameThemeByCategory(String category) {
        if (StringUtils.isBlank(category)) {
            return Optional.empty();
        }

        return create.selectFrom(Tables.NICKNAME_THEME)
                .where(Tables.NICKNAME_THEME.CATEGORY.eq(category))
                .fetchOptionalInto(NicknameTheme.class);
    }
}
