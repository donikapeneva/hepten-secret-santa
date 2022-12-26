package com.dg.heptensecretsanta.repository;

import com.dg.heptensecretsanta.dto.RoomDTO;
import com.dg.heptensecretsanta.pojo.RoomUserMapping;
import com.dg.heptensecretsanta.tables.pojos.Room;
import com.dg.heptensecretsanta.tables.pojos.User;

import java.util.List;
import java.util.Optional;

public interface RoomRepository {

    Room createRoom(Room room);

    void createRoomUserMapping(Room room, User user);

    void updateRoomUserMappingByRoomIdAndUserId(Integer roomId, Integer userId, Integer givesToUserId);

    Optional<List<User>> fetchRoomUserByRoomId(Integer roomId);

    Optional<RoomUserMapping> fetchRoomUserMappingByRoomIdAndUserId(Integer roomId, Integer userId);

    Optional<Room> fetchRoomByPassCode(String passCode);

    Optional<Room> fetchRoomById(Integer id);

    RoomDTO getAllInfoRoomUserMappingByRoomId(Integer roomId);

    void updateRoomStatus(Integer roomId, String newStatus);

    void createRoomGiftThemeMapping(Integer roomId, Integer categoryId);

    Room fetchRoomByName(String name);

}
