package com.dg.heptensecretsanta.repository;

import com.dg.heptensecretsanta.tables.pojos.GiftTheme;
import com.dg.heptensecretsanta.tables.pojos.GiftThemeUserMapping;

import java.util.List;
import java.util.Optional;

public interface GiftThemeRepository {

    Optional<GiftTheme> fetchGiftThemeByCategory(String category);
    Optional<List<GiftTheme>> fetchGiftThemeByRoomId(Integer roomId);
    Optional<List<GiftThemeUserMapping>> fetchGiftThemeByRoomAndUserMapping(Integer roomId, Integer userId);
    void insertGiftThemeUserMapping(Integer userId, Integer roomId, Integer categoryId, String giftAttribute);


}
