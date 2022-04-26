package com.local.conferencebooking.controllers;

import com.local.conferencebooking.forms.EventFormToFindByDate;
import com.local.conferencebooking.forms.EventFormToFindByName;
import com.local.conferencebooking.forms.UserForm;
import com.local.conferencebooking.models.User;
import com.local.conferencebooking.services.UserService;

import static com.local.conferencebooking.transfer.UserDto.from;

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

    @PostMapping("find/{id}")
    public ResponseEntity<Object> joinToRoomByName(@PathVariable Long id, @RequestBody EventFormToFindByName form){
        return service.joinToRoomByEventName(id, form.getName());
    }

    @PostMapping("/{id}")
    public ResponseEntity<Object> joinToRoom(@PathVariable Long id, @RequestBody EventFormToFindByDate eventForm){
        return service.joinToRoom(id, eventForm);
    }

    private User checkForExists(Long id) {
        return service.findOne(id);
    }

}
