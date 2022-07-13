package com.local.conferencebooking.controllers;

import com.local.conferencebooking.services.MeetRoomService;
import com.local.conferencebooking.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private MeetRoomService roomService;

    @PostMapping("/{id}")
    public String joinToRoom(@PathVariable Long id, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime date, Model model) {
        service.joinToRoom(id, date, model);
        roomService.getModels(model, date);
        return "meet-room";
    }
}
