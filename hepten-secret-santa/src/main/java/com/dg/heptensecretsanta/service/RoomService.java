package com.dg.heptensecretsanta.service;

import com.dg.heptensecretsanta.dto.CreateRoomDto;
import com.dg.heptensecretsanta.dto.UserDto;
import com.dg.heptensecretsanta.pojo.UserWithNickname;
import com.dg.heptensecretsanta.repository.RoomRepository;
import com.dg.heptensecretsanta.tables.pojos.GiftTheme;
import com.dg.heptensecretsanta.tables.pojos.NicknameTheme;
import com.dg.heptensecretsanta.tables.pojos.Room;
import com.dg.heptensecretsanta.tables.pojos.User;
import com.dg.heptensecretsanta.vo.EmailTemplate;
import com.dg.heptensecretsanta.web.validation.exception.ApiResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Arrays;
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

    public Integer createRoom(CreateRoomDto roomDto) {
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
        NicknameTheme nicknameTheme = nicknameThemeService.getNicknameThemeByCategory(roomDto.nicknameThemeCategory());

        // map the data


        Room room = roomRepository.createRoom(mapData(roomDto, user.get(), nicknameTheme));
        createRoomUserMapping(room, user.get());

        return room.getId();
    }

    private void createRoomUserMapping(Room room, User user) {
        roomRepository.createRoomUserMapping(room, user);
    }

    private Room mapData(CreateRoomDto roomDto, User user, NicknameTheme nicknameTheme) {
        Room room = new Room();
        room.setRoomName(roomDto.roomName());
        room.setPassCode(roomDto.passCode());
        room.setUserId(user.getId());
        room.setBudget(roomDto.budget());
        room.setNicknameThemeId(nicknameTheme.getId());
        room.setStatus("INITIALIZED");
        room.setReveal(false);

        return room;
    }

    public Integer registerUserToRoom(String passCode, UserDto userDto) {
        // find room
        Optional<Room> room = roomRepository.fetchRoomByPassCode(passCode);
        if (!room.isPresent()) {
            throw new ApiResourceNotFoundException("Missing room for passCode " + passCode);
        }

        // find user, or create one
        Optional<User> user = userService.getUserByUsername(userDto.username());
        if (!user.isPresent()) {
            user = Optional.of(
                    userService.createUser(new User(null, userDto.email(),
                            userDto.username(), LocalDateTime.now(ZoneOffset.UTC),
                            userDto.gender())));
        }

        createRoomUserMapping(room.get(), user.get());

        return user.get().getId();
    }

    public Integer mapPeople(Integer roomId) {

        Optional<Room> record = roomRepository.fetchRoomById(roomId);
        Room room = record.get();

        //update room status --> STARTED

        //get participants by room id
        Optional<List<User>> users = roomRepository.fetchRoomUserByRoomId(roomId);

        // get list of themed nicknames
        List<String> nicknames = new ArrayList<>(Arrays.asList(
                nicknameThemeService.getNicknameThemeById(room.getNicknameThemeId())
                .getNicknames().split(",")
        ));

        List<User> givers = users.get();
        List<User> receivers = users.get();

        //  for user in users -> assign nickname
        givers.stream()
                .forEach((user) -> {
                    UserWithNickname participant = new UserWithNickname();
                    participant.setUsername(user.getUsername());
                    //random number
                    int rando = (int)((Math.random()*nicknames.size()));
                    String randomNick = nicknames.remove(rando);
                    participant.setNickname(randomNick);
                    participant.setRoomId(roomId);
                    userService.createNicknameByUser(user.getId(), roomId, randomNick);
                });

        givers.stream()
                .forEach((giver) -> {
                    //do it smarter pls
                    int self = receivers.indexOf(giver);
                    int rando = 0;
                    while (rando == self && receivers.size() > 1) {
                        rando = (int)((Math.random() * receivers.size()));
                    }

                    User receiver = receivers.remove(rando);
                    System.out.println(">>>>>>>>>>>>>> giver " + giver.getId() + " receiver : " + receiver.getId());

                    roomRepository.updateRoomUserMappingByRoomIdAndUserId(roomId, giver.getId(), receiver.getId());

                    //select theme
        });


        return roomId;
    }
}
