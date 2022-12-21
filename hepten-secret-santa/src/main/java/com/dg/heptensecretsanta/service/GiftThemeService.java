package com.dg.heptensecretsanta.service;

import com.dg.heptensecretsanta.repository.GiftThemeRepository;
import com.dg.heptensecretsanta.tables.pojos.GiftTheme;
import com.dg.heptensecretsanta.web.validation.exception.ApiBadRequestException;
import com.dg.heptensecretsanta.web.validation.exception.ApiResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.jooq.tools.StringUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GiftThemeService {

    private final GiftThemeRepository giftThemeRepository;

    public GiftTheme getGiftThemeByCategory(String category) {
        if (StringUtils.isBlank(category)) {
            throw new ApiBadRequestException("Missing category");
        }

        return giftThemeRepository.fetchGiftThemeByCategory(category)
                .orElseThrow(() -> new ApiResourceNotFoundException("No existing category"));
    }
}
