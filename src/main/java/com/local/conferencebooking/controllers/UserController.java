package com.local.conferencebooking.controllers;

import com.local.conferencebooking.forms.EventFormToCreate;
import com.local.conferencebooking.forms.EventFormToFindByDate;
import com.local.conferencebooking.forms.EventFormToFindByName;
import com.local.conferencebooking.forms.UserForm;
import com.local.conferencebooking.models.Event;
import com.local.conferencebooking.models.User;
import com.local.conferencebooking.services.EventService;
import com.local.conferencebooking.services.MeetRoomService;
import com.local.conferencebooking.services.UserService;
import com.local.conferencebooking.transfer.EventDto;
import com.local.conferencebooking.transfer.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.local.conferencebooking.transfer.EventDto.from;
import static com.local.conferencebooking.transfer.UserDto.from;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private EventService eventService;

    @Autowired
    private MeetRoomService roomService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getOneUser(@PathVariable Long id) {
        User user = service.findOne(id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(from(user), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateInformation(@PathVariable Long id, @RequestBody UserForm updateForm) {
        if (checkForExists(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(from(service.updateUser(id, updateForm)), HttpStatus.ACCEPTED);
    }

    @PostMapping("/find/{id}")
    public ResponseEntity<EventDto> joinToRoomByName(@PathVariable Long id, @RequestBody EventFormToFindByName form) {
        return new ResponseEntity<>(from(service.joinToRoomByEventName(id, form.getName())), HttpStatus.ACCEPTED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<EventDto> joinToRoom(@PathVariable Long id, @RequestBody EventFormToFindByDate eventForm) {
        if (eventForm.getDate().getYear() == roomService.getTime().getYear()) {
            service.setEventStatus(eventForm.getDate(), roomService.getTime());
            return new ResponseEntity<>(from(service.joinToRoom(id, eventForm.getDate())), HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    private User checkForExists(Long id) {
        return service.findOne(id);
    }
}
