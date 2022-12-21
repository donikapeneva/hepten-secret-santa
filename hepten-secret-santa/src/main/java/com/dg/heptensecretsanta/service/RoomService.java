package com.dg.heptensecretsanta.service;

import com.dg.heptensecretsanta.dto.RoomDto;
import com.dg.heptensecretsanta.repository.RoomRepository;
import com.dg.heptensecretsanta.tables.pojos.*;
import com.dg.heptensecretsanta.vo.EmailTemplate;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

    private final UserService userService;

    private final GiftThemeService giftThemeService;

    private final NicknameThemeService nicknameThemeService;

    public void createRoom(RoomDto roomDto) {
        // find the user - think to move to the facade
        Optional<User> user = userService.getUserByUsername(roomDto.creatorUsername());
        if (!user.isPresent()) {
            user = Optional.of(
                userService.createUser(new User(null, EmailTemplate.MISSING_EMAIL.getValue(),
                        roomDto.creatorUsername(), LocalDateTime.now(ZoneOffset.UTC),
                        "female"))); // TODO: pass it with the auth or custom from the dto
        }

        // find gift theme
        List<GiftTheme> giftThemes = roomDto.giftThemeDtoList().stream()
                .map(el -> giftThemeService.getGiftThemeByCategory(el.category()))
                .collect(Collectors.toList());

        // find nickname theme
        NicknameTheme nicknameTheme = nicknameThemeService.getGiftThemeByCategory(roomDto.nicknameThemeCategory());

        // map the data


        Room room = roomRepository.createRoom(mapData(roomDto, user.get(), nicknameTheme));

        // insert roomuser mapping
        // ins

        // save the data
    }

    private Room mapData(RoomDto roomDto, User user, NicknameTheme nicknameTheme) {
        Room room = new Room();
        room.setRoomName(roomDto.roomName());
        room.setPassCode(roomDto.passCode());
        room.setUserId(user.getId());
        room.setBudget(roomDto.budget());
        room.setNicknameThemeId(nicknameTheme.getId());
        room.setStatus("INITIALIZED");
        room.set
        return room;
    }
}
