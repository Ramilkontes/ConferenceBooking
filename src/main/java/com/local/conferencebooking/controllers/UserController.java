package com.local.conferencebooking.controllers;

import com.local.conferencebooking.services.UserService;
import com.local.conferencebooking.transfer.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.local.conferencebooking.transfer.UserDto.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("users/all")
    public List<UserDto> getUsers() {
        return from(service.findAll());
    }

    @GetMapping("/{id}")
    public UserDto getOneUser(@PathVariable Long id){
        return from(service.findOne(id));
    }


}
