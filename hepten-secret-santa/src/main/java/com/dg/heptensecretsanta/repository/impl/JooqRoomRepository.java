package com.dg.heptensecretsanta.repository.impl;

import com.dg.heptensecretsanta.repository.RoomRepository;
import com.dg.heptensecretsanta.tables.pojos.Room;
import lombok.AllArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import static com.dg.heptensecretsanta.Tables.ROOM;

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
}
