package com.dg.heptensecretsanta.service;

import com.dg.heptensecretsanta.repository.NicknameThemeRepository;
import com.dg.heptensecretsanta.tables.pojos.NicknameTheme;
import com.dg.heptensecretsanta.web.validation.exception.ApiBadRequestException;
import com.dg.heptensecretsanta.web.validation.exception.ApiResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.jooq.tools.StringUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NicknameThemeService {

    private final NicknameThemeRepository nicknameThemeRepository;

    public NicknameTheme getGiftThemeByCategory(String category) {
        if (StringUtils.isBlank(category)) {
            throw new ApiBadRequestException("Missing category");
        }

        return nicknameThemeRepository.fetchNicknameThemeByCategory(category)
                .orElseThrow(() -> new ApiResourceNotFoundException("No existing category"));
    }
}
