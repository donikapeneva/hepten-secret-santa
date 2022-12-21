package com.dg.heptensecretsanta.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

public record RoomDto(@NotBlank String roomName, @NotBlank String passCode, @NotBlank String budget,
                      @JsonProperty("giftTheme") @NotEmpty List<GiftThemeDto> giftThemeDtoList,
                      @NotBlank String nicknameThemeCategory,
                      @NotBlank String creatorUsername) {
}
