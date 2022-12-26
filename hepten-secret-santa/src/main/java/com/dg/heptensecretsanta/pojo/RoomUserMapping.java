package com.dg.heptensecretsanta.pojo;

import lombok.Data;

import java.util.List;

@Data
public class RoomUserMapping {
    String giver;
    Integer giverId;
    String receiverNickname;
    String receiver;

    List<String> giftThemes;
}
