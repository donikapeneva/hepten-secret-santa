package com.dg.heptensecretsanta.dto;

import com.dg.heptensecretsanta.pojo.RoomUserMapping;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data

@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {
    List<RoomUserMapping> mapping;
    String budget;
    String roomName;
}
