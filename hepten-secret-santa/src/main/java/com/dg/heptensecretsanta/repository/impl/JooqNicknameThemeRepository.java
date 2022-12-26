package com.dg.heptensecretsanta.repository.impl;

import com.dg.heptensecretsanta.Tables;
import com.dg.heptensecretsanta.repository.NicknameThemeRepository;
import com.dg.heptensecretsanta.tables.pojos.GiftTheme;
import com.dg.heptensecretsanta.tables.pojos.NicknameTheme;
import lombok.AllArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.tools.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
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

    @Override
    public Optional<NicknameTheme> fetchNicknameThemeById(Integer id) {

        return create.selectFrom(Tables.NICKNAME_THEME)
                .where(Tables.NICKNAME_THEME.ID.eq(id))
                .fetchOptionalInto(NicknameTheme.class);
    }

    @Override
    public Optional<List<NicknameTheme>> fetchAllNicknameTheme() {
        List<NicknameTheme> records = create.selectFrom(Tables.NICKNAME_THEME)
                .fetchInto(NicknameTheme.class);

        return Optional.ofNullable(records);
    }
}
