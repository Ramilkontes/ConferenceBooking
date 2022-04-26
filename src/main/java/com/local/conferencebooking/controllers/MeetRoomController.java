package com.local.conferencebooking.controllers;

import com.local.conferencebooking.services.MeetRoomService;
import com.local.conferencebooking.transfer.AdminEventsDto;
import com.local.conferencebooking.transfer.AdminUsersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/meet-room")
public class MeetRoomController {

    @Autowired
    private MeetRoomService service;

    @GetMapping("/people")
    public List<AdminUsersDto> getAllPeople() {
        return service.getAllPeople();
    }

    @GetMapping("/rooms")
    public List<AdminEventsDto> getAllRooms() {
        return service.gerAllRooms();
    }

    @GetMapping
    public LocalDateTime getTimeToday() {
        return service.getTime();
    }
}
