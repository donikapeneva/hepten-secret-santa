package com.dg.heptensecretsanta.repository.impl;

import com.dg.heptensecretsanta.dto.RoomDTO;
import com.dg.heptensecretsanta.pojo.RoomUserMapping;
import com.dg.heptensecretsanta.repository.RoomRepository;
import com.dg.heptensecretsanta.tables.pojos.Room;
import com.dg.heptensecretsanta.tables.pojos.User;
import lombok.AllArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.Record;
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
    public Optional<RoomUserMapping> fetchRoomUserMappingByRoomIdAndUserId(Integer roomId, Integer userId) {
        return create.selectFrom(ROOM_USER_MAPPING)
                .where(ROOM_USER_MAPPING.ROOM_ID.eq(roomId))
                .and(ROOM_USER_MAPPING.USER_ID.eq(userId))
                .fetchOptionalInto(RoomUserMapping.class);
    }

    @Override
    public Optional<Room> fetchRoomByPassCode(String passCode) {
        return create.selectFrom(ROOM)
                .where(ROOM.PASS_CODE.eq(passCode))
                .fetchOptionalInto(Room.class);

    }

    @Override
    public Room fetchRoomByName(String name) {
        return create.selectFrom(ROOM)
                .where(ROOM.ROOM_NAME.eq(name))
                .fetchAnyInto(Room.class);

    }

    @Override
    public Optional<Room> fetchRoomById(Integer id) {
        return create.selectFrom(ROOM)
                .where(ROOM.ID.eq(id))
                .fetchOptionalInto(Room.class);
    }


    @Override
    public RoomDTO getAllInfoRoomUserMappingByRoomId(Integer roomId) {

//        select rum.user_id, giver.username, giver_n.nickname, rum.give_to, receiver.username, receiver_n.nickname
//        from public.room_user_mapping rum
//        join public.nickname_user_mapping receiver_n
//        on rum.give_to = receiver_n.user_id
//        join public.user receiver
//        on rum.give_to = receiver.id
//        join public.nickname_user_mapping giver_n
//        on rum.user_id = giver_n.user_id
//        join public.user giver
//        on rum.user_id = giver.id
//        ;

        com.dg.heptensecretsanta.tables.RoomUserMapping rum = ROOM_USER_MAPPING.as("rum");
        com.dg.heptensecretsanta.tables.NicknameUserMapping giver_n = NICKNAME_USER_MAPPING.as("giver_n");
        com.dg.heptensecretsanta.tables.User giver = USER.as("giver");

        com.dg.heptensecretsanta.tables.NicknameUserMapping receiver_n = NICKNAME_USER_MAPPING.as("receiver_n");
        com.dg.heptensecretsanta.tables.User receiver = USER.as("receiver");

        List<RoomUserMapping> fetch = create
                .select(rum.USER_ID,
                        giver.ID,
                        giver.USERNAME,
                        giver_n.NICKNAME,
                        rum.GIVE_TO,
                        receiver.USERNAME,
                        receiver_n.NICKNAME
                ).from(rum)
                .join(receiver_n)
                .on(rum.GIVE_TO.eq(receiver_n.USER_ID))
                .join(receiver)
                .on(rum.GIVE_TO.eq(receiver.ID))

                .join(giver_n)
                .on(rum.USER_ID.eq(giver_n.USER_ID))
                .join(giver)
                .on(rum.USER_ID.eq(giver.ID))

                .where(rum.ROOM_ID.eq(roomId))
                .fetch(this::createRoomMappingFromRecord);

        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setMapping(fetch);
        return roomDTO;
    }

    @Override
    public void updateRoomStatus(Integer roomId, String status) {
        create.update(ROOM)
                .set(ROOM.STATUS, status)
                .where(ROOM.ID.eq(roomId))
                .execute();
    }

    @Override
    public void createRoomGiftThemeMapping(Integer roomId, Integer categoryId) {
        create.insertInto(GIFT_THEME_ROOM_MAPPING)
                .set(GIFT_THEME_ROOM_MAPPING.GIFT_THEME_ID, categoryId)
                .set(GIFT_THEME_ROOM_MAPPING.ROOM_ID, roomId)
                .execute();
    }


    private RoomUserMapping createRoomMappingFromRecord(Record record) {

        com.dg.heptensecretsanta.tables.RoomUserMapping rum = ROOM_USER_MAPPING.as("rum");
        com.dg.heptensecretsanta.tables.NicknameUserMapping giver_n = NICKNAME_USER_MAPPING.as("giver_n");
        com.dg.heptensecretsanta.tables.User giver = USER.as("giver");

        com.dg.heptensecretsanta.tables.NicknameUserMapping receiver_n = NICKNAME_USER_MAPPING.as("receiver_n");
        com.dg.heptensecretsanta.tables.User receiver = USER.as("receiver");


        RoomUserMapping roomMappingPojo = new RoomUserMapping();
        roomMappingPojo.setGiver(record.field(giver.USERNAME).getValue(record));
        roomMappingPojo.setReceiverNickname(record.field(receiver_n.NICKNAME).getValue(record));
        roomMappingPojo.setReceiver(record.field(receiver.USERNAME).getValue(record));
        roomMappingPojo.setGiverId(record.field(giver.ID).getValue(record));

        return roomMappingPojo;
    }


}
