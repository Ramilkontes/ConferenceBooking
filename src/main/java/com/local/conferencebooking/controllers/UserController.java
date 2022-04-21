package com.local.conferencebooking.controllers;

import com.local.conferencebooking.models.User;
import com.local.conferencebooking.services.UserService;
import static com.local.conferencebooking.transfer.UserDto.*;

import com.local.conferencebooking.transfer.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getOneUser(@PathVariable Long id) {
        User user = service.findOne(id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        UserDto result = from(user);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}
