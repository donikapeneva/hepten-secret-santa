package com.dg.heptensecretsanta.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data

@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {
    List<RoomUserMappingDTO> mapping;
    String budget;
    String status;
    String roomName;
}
