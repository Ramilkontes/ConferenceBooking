package com.local.conferencebooking.controllers;

import com.local.conferencebooking.services.MeetRoomService;
import com.local.conferencebooking.services.ServiceClassForDate;
import com.local.conferencebooking.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private MeetRoomService roomService;

    @Autowired
    private ServiceClassForDate classForDate;

    @PostMapping("/{id}")
    public String joinToRoom(@PathVariable Long id, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime date, Model model) {
        List<LocalDate> week = roomService.getWeek(classForDate.getDate(1L));
        service.joinToRoom(id, date, model);
        roomService.getModels(model, week);
        model.addAttribute("week", week);
        return "meet-room";
    }
}
