package com.dg.heptensecretsanta.service;

import com.dg.heptensecretsanta.dto.CreateRoomDto;
import com.dg.heptensecretsanta.dto.EnterRoomDto;
import com.dg.heptensecretsanta.dto.RoomDTO;
import com.dg.heptensecretsanta.dto.UserDto;
import com.dg.heptensecretsanta.pojo.RoomUserMapping;
import com.dg.heptensecretsanta.pojo.UserWithNickname;
import com.dg.heptensecretsanta.repository.RoomRepository;
import com.dg.heptensecretsanta.tables.pojos.*;
import com.dg.heptensecretsanta.vo.EmailTemplate;
import com.dg.heptensecretsanta.web.validation.exception.ApiBadRequestException;
import com.dg.heptensecretsanta.web.validation.exception.ApiResourceNotFoundException;
import com.dg.heptensecretsanta.web.validation.exception.ApiValidationException;
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

    public static final String STATUS_REVEALED = "REVEALED";
    public static final String STATUS_INIT = "INITIALIZED";
    public static final String STATUS_STARTED = "STARTED";
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

        Room existingRoom = roomRepository.fetchRoomByName(roomDto.roomName());
        if(existingRoom != null) {
            throw new ApiBadRequestException("Room exists");
        }

        // find gift theme
        List<GiftTheme> giftThemes = roomDto.giftThemeDtoList().stream()
                .map(category -> giftThemeService.getGiftThemeByCategory(category))
                .collect(Collectors.toList());

        // find nickname theme
        NicknameTheme nicknameTheme = nicknameThemeService.getNicknameThemeByCategory(roomDto.nicknameThemeCategory());

        // map the data


        Room room = roomRepository.createRoom(mapData(roomDto, user.get(), nicknameTheme));
        createRoomUserMapping(room, user.get());
        giftThemes.forEach(giftTheme -> {
            createRoomGiftMapping(room.getId(), giftTheme.getId());
        });

        return room.getId();
    }

    private void createRoomUserMapping(Room room, User user) {
        roomRepository.createRoomUserMapping(room, user);
    }

    private void createRoomGiftMapping(Integer roomId, Integer categoryId) {
        roomRepository.createRoomGiftThemeMapping(roomId, categoryId);
    }

    private Room mapData(CreateRoomDto roomDto, User user, NicknameTheme nicknameTheme) {
        Room room = new Room();
        room.setRoomName(roomDto.roomName());
        room.setPassCode(roomDto.passCode());
        room.setUserId(user.getId());
        room.setBudget(roomDto.budget());
        room.setNicknameThemeId(nicknameTheme.getId());
        room.setStatus(STATUS_INIT);
        room.setReveal(false);

        return room;
    }

    public Integer registerUserToRoom(String roomName, EnterRoomDto enterRoomDto) {

        // find room
        Room room = roomRepository.fetchRoomByName(roomName);
        if (room == null) {
            throw new ApiResourceNotFoundException("Missing room  " + roomName);
        }

        if (!room.getPassCode().equals(enterRoomDto.passCode())) {
            throw new ApiResourceNotFoundException("Wrong room pass for " + roomName);
        }

        // find user, or create one
        Optional<User> user = userService.getUserByUsername(enterRoomDto.username());
        if (!user.isPresent()) {
            user = Optional.of(
                    userService.createUser(new User(null, enterRoomDto.email(),
                            enterRoomDto.username(), LocalDateTime.now(ZoneOffset.UTC),
                            enterRoomDto.gender())));
        } else {
            Optional<RoomUserMapping> registeredUser = roomRepository.fetchRoomUserMappingByRoomIdAndUserId(room.getId(), user.get().getId());
            if(registeredUser.isPresent()){
                return room.getId();
            }
        }

        createRoomUserMapping(room, user.get());

        return room.getId();
    }

    public RoomDTO mapPeople(Integer roomId) {

        roomRepository.updateRoomStatus(roomId, STATUS_STARTED);

        Optional<Room> record = roomRepository.fetchRoomById(roomId);
        Room room = record.get();

        //get participants by room id
        Optional<List<User>> users = roomRepository.fetchRoomUserByRoomId(roomId);

        // get list of themed nicknames
        List<String> nicknames = new ArrayList<>(Arrays.asList(
                nicknameThemeService.getNicknameThemeById(room.getNicknameThemeId())
                .getNicknames().split(",")
        ));

        List<User> givers = users.get().stream().toList();
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
        });

        List<GiftTheme> giftThemeCategories = giftThemeService.getGiftThemeByRoomId(roomId);
        giftThemeCategories.stream()
                .forEach((category) -> {
                    ArrayList<String> giftThemes = new ArrayList<>(Arrays.asList(
                            category.getAttributes().split(",")));

                    givers.stream()
                            .forEach((giver) -> {
                                int rando = (int)((Math.random() * giftThemes.size()));
                                String randomTheme = giftThemes.remove(rando);

                                giftThemeService.createGiftThemeUserMapping(giver.getId(), roomId, category.getId(),randomTheme);

                            });

                });

        return roomRepository.getAllInfoRoomUserMappingByRoomId(roomId);
    }

    public RoomDTO reveal(Integer roomId) {
        roomRepository.updateRoomStatus(roomId, STATUS_REVEALED);
        return roomRepository.getAllInfoRoomUserMappingByRoomId(roomId);
    }

    public RoomDTO getAllInfoRoomUserMappingByRoomId(Integer roomId) {
        RoomDTO userMapping = roomRepository.getAllInfoRoomUserMappingByRoomId(roomId);
        Room room = roomRepository.fetchRoomById(roomId).get();


        RoomDTO allInfoMapping = new RoomDTO();
        allInfoMapping.setMapping(
                userMapping.getMapping().stream().map((pair) -> {
                    List<GiftThemeUserMapping> giftThemes = giftThemeService.getGiftThemeByRoomAndUserMapping(roomId, pair.getGiverId());
                    pair.setGiftThemes(giftThemes.stream().map(theme -> theme.getGiftAttribute()).toList());
                    return pair;
                }).toList()
        );
        allInfoMapping.setBudget(room.getBudget());
        allInfoMapping.setRoomName(room.getRoomName());

        return allInfoMapping;
    }


    public RoomDTO getMapping(Integer roomId) {
        Optional<Room> room = roomRepository.fetchRoomById(roomId);

        switch(room.get().getStatus()) {
            case (STATUS_REVEALED):
                return this.getAllInfoRoomUserMappingByRoomId(roomId);
            case (STATUS_STARTED):

                RoomDTO roomDto = this.getAllInfoRoomUserMappingByRoomId(roomId);
                roomDto.setMapping(roomDto.getMapping().stream()
                        .map(pair -> {
                            pair.setReceiver(null);
                            return pair;
                        })
                        .toList());
                return roomDto;
            case (STATUS_INIT):
            default:
                return this.getUsersInRoom(roomId);
        }

    }

    private RoomDTO getUsersInRoom(Integer roomId) {
        Optional<List<User>> usersInRoom = roomRepository.fetchRoomUserByRoomId(roomId);
        RoomDTO roomInfo = new RoomDTO();

        if(!usersInRoom.isPresent()) {
            return roomInfo;
        }

        List<RoomUserMapping> givers = usersInRoom.get().stream()
                .map((user) -> {
                    RoomUserMapping mapping = new RoomUserMapping();
                    mapping.setGiver(user.getUsername());
                    return mapping;
                })
                .toList();
        roomInfo.setMapping(givers);
        return roomInfo;
    }


}
