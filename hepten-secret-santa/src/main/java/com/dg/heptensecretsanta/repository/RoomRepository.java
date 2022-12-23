package com.dg.heptensecretsanta.repository;

import com.dg.heptensecretsanta.tables.pojos.Room;
import com.dg.heptensecretsanta.tables.pojos.User;

import java.util.Optional;

public interface RoomRepository {

    Room createRoom(Room room);

    void createRoomUserMapping(Room room, User user);

    Optional<Room> fetchRoomByPassCode(String passCode);
}
