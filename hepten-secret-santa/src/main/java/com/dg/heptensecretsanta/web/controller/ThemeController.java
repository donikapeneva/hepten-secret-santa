package com.dg.heptensecretsanta.web.controller;


import com.dg.heptensecretsanta.dto.GiftThemeDto;
import com.dg.heptensecretsanta.dto.NicknameThemeDto;
import com.dg.heptensecretsanta.dto.RoomDTO;
import com.dg.heptensecretsanta.service.GiftThemeService;
import com.dg.heptensecretsanta.service.NicknameThemeService;
import com.dg.heptensecretsanta.service.RoomService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@AllArgsConstructor
@RestController
@Validated
@RequestMapping("/secret-santa/themes")
@CrossOrigin
public class ThemeController {

    private final GiftThemeService giftThemeService;
    private final NicknameThemeService nicknameThemeService;

    @GetMapping("/gift")
    public GiftThemeDto getGiftThemes() {
        return giftThemeService.getAllGiftTheme();
    }


    @GetMapping("/nicknames")
    public NicknameThemeDto getNicknameThemes() {
        return nicknameThemeService.getAllNicknameTheme();
    }

}
