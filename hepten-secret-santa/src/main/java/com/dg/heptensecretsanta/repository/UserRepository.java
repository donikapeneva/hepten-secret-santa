package com.dg.heptensecretsanta.repository;

import com.dg.heptensecretsanta.pojo.Receiver;
import com.dg.heptensecretsanta.tables.pojos.NicknameUserMapping;
import com.dg.heptensecretsanta.tables.pojos.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    Optional<User> fetchUserByUsername(String username);

    User createUser(User user);

    NicknameUserMapping createNicknameByUser(Integer userId, Integer roomId, String nickname);

}
