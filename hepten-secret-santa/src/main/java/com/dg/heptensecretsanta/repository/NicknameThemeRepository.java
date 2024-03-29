package com.dg.heptensecretsanta.repository;

import com.dg.heptensecretsanta.tables.pojos.NicknameTheme;

import java.util.List;
import java.util.Optional;

public interface NicknameThemeRepository {

    Optional<NicknameTheme> fetchNicknameThemeByCategory(String category);
    Optional<NicknameTheme> fetchNicknameThemeById(Integer id);
    Optional<List<NicknameTheme>> fetchAllNicknameTheme();

}
