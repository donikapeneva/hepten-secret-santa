package com.dg.heptensecretsanta.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class NicknameThemeDto {
    List<String> categories;
}
