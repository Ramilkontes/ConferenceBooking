package com.local.conferencebooking.controllers;

import com.local.conferencebooking.forms.EventFormToCreate;
import com.local.conferencebooking.models.Event;
import com.local.conferencebooking.services.EventService;
import com.local.conferencebooking.transfer.EventDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

import static com.local.conferencebooking.transfer.EventDto.*;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService service;

    @GetMapping("/{id}")
    public ResponseEntity<EventDto> getInfo (@PathVariable Long id){
        if (checkForExists(id)==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        EventDto result = from(Objects.requireNonNull(checkForExists(id)));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<EventDto> createRoom (@RequestBody EventFormToCreate eventFormToCreate){
        service.createEvent(eventFormToCreate);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventDto> updateInformation (@PathVariable Long id, @RequestBody EventFormToCreate updateForm){
        if (checkForExists(id)==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(from(service.updateEvent(id, updateForm)), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EventDto> deleteRoom(@PathVariable Long id){
        if (checkForExists(id)==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(from(service.deleteEvent(id)), HttpStatus.OK);
    }

    private Event checkForExists(Long id) {
        return service.getOne(id);
    }
}
