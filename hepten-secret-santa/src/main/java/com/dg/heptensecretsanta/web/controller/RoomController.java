package com.dg.heptensecretsanta.web.controller;

import com.dg.heptensecretsanta.dto.RoomDto;
import com.dg.heptensecretsanta.service.RoomService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController
@Validated
@RequestMapping("/secret-santa/rooms")
public class RoomController {

    private final RoomService roomService;

    @PostMapping
    public String createRoom(@RequestBody RoomDto roomDto) {


        return "OK";
    }
}
