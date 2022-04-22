package com.local.conferencebooking.controllers;

import com.local.conferencebooking.forms.UserForm;
import com.local.conferencebooking.models.Room;
import com.local.conferencebooking.models.User;
import com.local.conferencebooking.services.UserService;

import static com.local.conferencebooking.transfer.UserDto.from;

import com.local.conferencebooking.transfer.RoomDto;
import com.local.conferencebooking.transfer.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return new ResponseEntity<>(from(user), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateInformation (@PathVariable Long id, @RequestBody UserForm updateForm){
        if (checkForExists(id)==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(from(service.updateUser(id, updateForm)), HttpStatus.ACCEPTED);
    }

    private User checkForExists(Long id) {
        return service.findOne(id);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Object> joinToRoom(@PathVariable Long id, String name){
        return service.joinToRoom(id, name);
    }

}
