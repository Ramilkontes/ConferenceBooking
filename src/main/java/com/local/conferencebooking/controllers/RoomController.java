package com.local.conferencebooking.controllers;

import com.local.conferencebooking.forms.RoomForm;
import com.local.conferencebooking.models.Room;
import com.local.conferencebooking.services.RoomService;
import com.local.conferencebooking.transfer.RoomDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

import static com.local.conferencebooking.transfer.RoomDto.*;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomService service;

    @GetMapping("/{id}")
    public ResponseEntity<RoomDto> getInfo (@PathVariable Long id){
        if (checkForExists(id)==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        RoomDto result = from(Objects.requireNonNull(checkForExists(id)));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<RoomDto> createRoom (@RequestBody RoomForm roomForm){
        service.createRoom(roomForm);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoomDto> updateInformation (@PathVariable Long id, @RequestBody RoomForm updateForm){
        if (checkForExists(id)==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(from(service.updateRoom(id, updateForm)), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RoomDto> deleteRoom(@PathVariable Long id){
        if (checkForExists(id)==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(from(service.deleteRoom(id)), HttpStatus.OK);
    }

    private Room checkForExists(Long id) {
        return service.getOne(id);
    }
}
