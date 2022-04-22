package com.local.conferencebooking.services;

import com.local.conferencebooking.forms.RoomForm;
import com.local.conferencebooking.models.Room;
import com.local.conferencebooking.models.RoomStatus;
import com.local.conferencebooking.repositories.RoomRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepositories repositories;

    @Override
    public Room getOne(Long id) {
        return repositories.getById(id);
    }

    @Override
    public void createRoom(RoomForm roomForm) {
        Room room = Room.builder()
                .name(roomForm.getName())
                .date(roomForm.getDate())
                .amountPeople(1)
                .status(RoomStatus.INACTIVE)
                .build();
         repositories.save(room);
    }

    @Override
    public Room updateRoom(Long id, RoomForm updateForm) {
        Room room = repositories.getById(id);
        room.setName(updateForm.getName());
        room.setDate(updateForm.getDate());
        return repositories.save(room);
    }

    @Override
    public Room deleteRoom(Long id) {
        Optional<Room> room = repositories.findById(id);
        room.ifPresent(del -> repositories.delete(del));
        return room.get();
    }
}
