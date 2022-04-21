package com.local.conferencebooking.controllers;

import com.local.conferencebooking.forms.RoomForms;
import com.local.conferencebooking.models.Room;
import com.local.conferencebooking.services.RoomService;
import com.local.conferencebooking.transfer.RoomDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.local.conferencebooking.transfer.RoomDto.*;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomService service;

    @GetMapping("/{id}")
    public ResponseEntity<RoomDto> getInfo (@PathVariable Long id){
        Room room = service.getOne(id);
        if(room == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        RoomDto result = from(room);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<RoomDto> createRoom (@RequestBody RoomForms roomForms){
        service.createRoom(roomForms);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public RoomDto updateInformation (@PathVariable Long id, @RequestBody RoomForms updateForm){
        return from(service.updateRoom(id, updateForm));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteRoom(@PathVariable Long id){
        service.deleteRoom(id);
        return ResponseEntity.ok("Удалено");
    }
}
