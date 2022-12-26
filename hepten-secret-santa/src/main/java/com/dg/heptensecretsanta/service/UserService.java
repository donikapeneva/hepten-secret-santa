package com.dg.heptensecretsanta.service;

import com.dg.heptensecretsanta.pojo.Receiver;
import com.dg.heptensecretsanta.repository.UserRepository;
import com.dg.heptensecretsanta.tables.pojos.NicknameUserMapping;
import com.dg.heptensecretsanta.tables.pojos.User;
import com.dg.heptensecretsanta.web.validation.exception.ApiBadRequestException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jooq.tools.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User createUser(User user) {
        if (user == null || StringUtils.isBlank(user.getUsername())) {
            throw new ApiBadRequestException("Missing data to create a user");
        }

        return userRepository.createUser(user);
    }

    public Optional<User> getUserByUsername(String username) {
        if (StringUtils.isBlank(username)) {
            throw new ApiBadRequestException("Missing username");
        }

        return userRepository.fetchUserByUsername(username);
    }

    public NicknameUserMapping createNicknameByUser(Integer userId, Integer roomId, String nickname) {
//        if (user == null || StringUtils.isBlank(user.getUsername())) {
//            throw new ApiBadRequestException("Missing data to create a user");
//        }

        return userRepository.createNicknameByUser(userId, roomId, nickname);
    }

}
