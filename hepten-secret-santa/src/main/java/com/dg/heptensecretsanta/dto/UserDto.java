package com.dg.heptensecretsanta.dto;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Validated
public record UserDto(@NotBlank String email, @NotBlank String username, @NotBlank String gender) {
}
