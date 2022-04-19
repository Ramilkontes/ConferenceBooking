package com.local.conferencebooking.controllers;

import com.local.conferencebooking.models.Room;
import com.local.conferencebooking.models.User;
import com.local.conferencebooking.services.DesktopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/desktop")
public class DesktopController {

    @Autowired
    private DesktopService service;

    /*@GetMapping
    public List<User> getAllPeople (){
        return service.getAllPeople();
    }

    @GetMapping
    public List<Room> getAllRooms(){
        return service.gerAllRooms();
    }*/

}
