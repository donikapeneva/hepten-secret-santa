package com.dg.heptensecretsanta.repository;

import com.dg.heptensecretsanta.tables.pojos.GiftTheme;

import java.util.Optional;

public interface GiftThemeRepository {

    Optional<GiftTheme> fetchGiftThemeByCategory(String category);

}
