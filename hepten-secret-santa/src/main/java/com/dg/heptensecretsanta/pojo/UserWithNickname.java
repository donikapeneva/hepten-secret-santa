package com.dg.heptensecretsanta.pojo;

import lombok.Data;

@Data
public class UserWithNickname {
    String username;
    String nickname;
    Integer roomId;
    Integer givesTo;
}
