package com.dg.heptensecretsanta.repository;

import com.dg.heptensecretsanta.tables.pojos.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> fetchUserByUsername(String username);

    User createUser(User user);
}