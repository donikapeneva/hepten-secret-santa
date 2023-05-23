package com.dg.heptensecretsanta.dto;

import lombok.Data;

import java.util.List;

@Data
public class RoomUserMappingDTO {
    String giver;
    Integer giverId;
    String receiverNickname;
    String receiver;

    List<String> giftThemes;
}
