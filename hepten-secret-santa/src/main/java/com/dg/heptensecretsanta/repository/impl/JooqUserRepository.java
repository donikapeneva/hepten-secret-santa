package com.dg.heptensecretsanta.repository.impl;

import com.dg.heptensecretsanta.Tables;
import com.dg.heptensecretsanta.repository.UserRepository;
import com.dg.heptensecretsanta.tables.pojos.NicknameUserMapping;
import com.dg.heptensecretsanta.tables.pojos.User;
import lombok.AllArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.tools.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class JooqUserRepository implements UserRepository {

    private final DSLContext create;

    @Override
    public Optional<User> fetchUserByUsername(String username) {
        if (StringUtils.isBlank(username)) {
            return Optional.empty();
        }

        return create.selectFrom(Tables.USER)
                .where(Tables.USER.USERNAME.eq(username))
                .fetchOptionalInto(User.class);
    }

    @Override
    public User createUser(User user) {
        return create.insertInto(Tables.USER, Tables.USER.USERNAME, Tables.USER.EMAIL,
                Tables.USER.CREATED_AT)
                .values(user.getUsername(), user.getEmail(), user.getCreatedAt())
                .returningResult(Tables.USER)
                .fetchOneInto(User.class);
    }

    @Override
    public NicknameUserMapping createNicknameByUser(Integer userId, Integer roomId, String nickname) {
        return create.insertInto(Tables.NICKNAME_USER_MAPPING)
                .values(userId, roomId, nickname)
                .returningResult(Tables.NICKNAME_USER_MAPPING)
                .fetchOneInto(NicknameUserMapping.class);
    }


}
