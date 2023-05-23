package com.dg.heptensecretsanta.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Validated
public record CreateRoomDto(@NotBlank String roomName, @NotBlank String passCode, @NotBlank String budget,
                            @JsonProperty("giftTheme") @NotEmpty List<String> giftThemeDtoList,
                            @NotBlank String nicknameThemeCategory,
                            @NotBlank String creatorUsername) {
}
