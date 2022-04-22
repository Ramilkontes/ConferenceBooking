package com.local.conferencebooking.controllers;

import com.local.conferencebooking.services.DesktopService;
import com.local.conferencebooking.transfer.AdminRoomsDto;
import com.local.conferencebooking.transfer.AdminUsersDto;
import com.local.conferencebooking.transfer.RoomDto;
import com.local.conferencebooking.transfer.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/desktop")
public class DesktopController {

    @Autowired
    private DesktopService service;

    @GetMapping("/people")
    public List<AdminUsersDto> getAllPeople() {
        return service.getAllPeople();
    }

    @GetMapping("/rooms")
    public List<AdminRoomsDto> getAllRooms() {
        return service.gerAllRooms();
    }

    @GetMapping
    public LocalDate getTime (Date date){
        return service.getTime(date);
    }
}
