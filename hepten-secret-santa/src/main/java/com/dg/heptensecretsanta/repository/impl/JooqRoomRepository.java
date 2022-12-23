package com.dg.heptensecretsanta.repository.impl;

import com.dg.heptensecretsanta.repository.RoomRepository;
import com.dg.heptensecretsanta.tables.pojos.Room;
import com.dg.heptensecretsanta.tables.pojos.User;
import lombok.AllArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.dg.heptensecretsanta.Tables.ROOM;
import static com.dg.heptensecretsanta.Tables.ROOM_USER_MAPPING;

@Repository
@AllArgsConstructor
public class JooqRoomRepository implements RoomRepository {

    private final DSLContext create;

    @Override
    public Room createRoom(Room room) {
        return create.insertInto(ROOM)
                .set(ROOM.ROOM_NAME, room.getRoomName())
                .set(ROOM.PASS_CODE, room.getPassCode())
                .set(ROOM.USER_ID, room.getUserId())
                .set(ROOM.BUDGET, room.getBudget())
                .set(ROOM.NICKNAME_THEME_ID, room.getNicknameThemeId())
                .set(ROOM.STATUS, room.getStatus())
                .returningResult(ROOM)
                .fetchOneInto(Room.class);
    }

    @Override
    public void createRoomUserMapping(Room room, User user) {
        create.insertInto(ROOM_USER_MAPPING)
                .set(ROOM_USER_MAPPING.ROOM_ID, room.getId())
                .set(ROOM_USER_MAPPING.USER_ID, user.getId())
                .execute();
    }

    @Override
    public Optional<Room> fetchRoomByPassCode(String passCode) {
        return create.selectFrom(ROOM)
                .where(ROOM.PASS_CODE.eq(passCode))
                .fetchOptionalInto(Room.class);

    }
}
