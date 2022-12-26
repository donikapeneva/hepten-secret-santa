package com.dg.heptensecretsanta.dto;


import javax.validation.constraints.NotBlank;

public record EnterRoomDto(@NotBlank String username, @NotBlank String passCode,
                           @NotBlank String gender, String email ) {
}
