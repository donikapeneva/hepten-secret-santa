package com.dg.heptensecretsanta.repository.impl;

import com.dg.heptensecretsanta.repository.RoomRepository;
import com.dg.heptensecretsanta.tables.pojos.Room;
import com.dg.heptensecretsanta.tables.pojos.User;
import lombok.AllArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.dg.heptensecretsanta.Tables.*;

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
    public void updateRoomUserMappingByRoomIdAndUserId(Integer roomId, Integer userId, Integer givesToUserId) {
        create.update(ROOM_USER_MAPPING)
                .set(ROOM_USER_MAPPING.GIVE_TO, givesToUserId)
                .where(ROOM_USER_MAPPING.ROOM_ID.eq(roomId))
                .and(ROOM_USER_MAPPING.USER_ID.eq(userId))
                .execute();

    }

    @Override
    public Optional<List<User>> fetchRoomUserByRoomId(Integer roomId) {
        List<User> records = create.selectFrom(USER
                    .join(ROOM_USER_MAPPING)
                    .on(ROOM_USER_MAPPING.USER_ID.eq(USER.ID))
                )
                .where(ROOM_USER_MAPPING.ROOM_ID.eq(roomId))
                .fetchInto(User.class);

        return Optional.ofNullable(records);


    }

    @Override
    public Optional<Room> fetchRoomByPassCode(String passCode) {
        return create.selectFrom(ROOM)
                .where(ROOM.PASS_CODE.eq(passCode))
                .fetchOptionalInto(Room.class);

    }

    @Override
    public Optional<Room> fetchRoomById(Integer id) {
        return create.selectFrom(ROOM)
                .where(ROOM.ID.eq(id))
                .fetchOptionalInto(Room.class);
    }
}
