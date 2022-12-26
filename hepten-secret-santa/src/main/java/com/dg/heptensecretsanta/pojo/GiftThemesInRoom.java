package com.dg.heptensecretsanta.pojo;

import com.dg.heptensecretsanta.tables.pojos.GiftTheme;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GiftThemesInRoom {
    List<GiftTheme> giftThemes;
}
