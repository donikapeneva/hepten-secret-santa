package com.dg.heptensecretsanta.service;

import com.dg.heptensecretsanta.dto.GiftThemeDto;
import com.dg.heptensecretsanta.repository.GiftThemeRepository;
import com.dg.heptensecretsanta.tables.pojos.GiftTheme;
import com.dg.heptensecretsanta.tables.pojos.GiftThemeUserMapping;
import com.dg.heptensecretsanta.web.validation.exception.ApiBadRequestException;
import com.dg.heptensecretsanta.web.validation.exception.ApiResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.jooq.tools.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<GiftTheme> getGiftThemeByRoomId(Integer roomId) {
//        if (StringUtils.isBlank(category)) {
//            throw new ApiBadRequestException("Missing category");
//        }

        return giftThemeRepository.fetchGiftThemeByRoomId(roomId).get();
    }

    public void createGiftThemeUserMapping(Integer userId, Integer roomId, Integer categoryId, String giftAttribute) {
//        if (StringUtils.isBlank(category)) {
//            throw new ApiBadRequestException("Missing category");
//        }

        giftThemeRepository.insertGiftThemeUserMapping(userId, roomId, categoryId, giftAttribute);
    }

    public List<GiftThemeUserMapping> getGiftThemeByRoomAndUserMapping(Integer roomId, Integer userId) {
        return giftThemeRepository.fetchGiftThemeByRoomAndUserMapping(roomId, userId).get();
    }


    public GiftThemeDto getAllGiftTheme() {
        return new GiftThemeDto(giftThemeRepository.fetchAllGiftTheme().get().stream().map(theme -> theme.getCategory()).toList());
    }

}
