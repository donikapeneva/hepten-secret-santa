package com.dg.heptensecretsanta.web.controller;

import com.dg.heptensecretsanta.dto.CreateRoomDto;
import com.dg.heptensecretsanta.dto.UserDto;
import com.dg.heptensecretsanta.service.RoomService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@AllArgsConstructor
@RestController
@Validated
@RequestMapping("/secret-santa/rooms")
public class RoomController {

    private final RoomService roomService;

    @PostMapping
    public Integer createRoom(@RequestBody CreateRoomDto roomDto) {
        return roomService.createRoom(roomDto);
    }

    @PostMapping("/{roomPassCode}/users")
    public Integer registerUserToRoom(@PathVariable String roomPassCode, @RequestBody UserDto userDto) {
        return roomService.registerUserToRoom(roomPassCode, userDto);
    }

}
