package com.local.conferencebooking.services;

import com.local.conferencebooking.forms.RoomForms;
import com.local.conferencebooking.models.Room;
import com.local.conferencebooking.models.RoomStatus;
import com.local.conferencebooking.repositories.RoomRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepositories repositories;

    @Override
    public Room getOne(Long id) {
        return repositories.getById(id);
    }

    @Override
    public void createRoom(RoomForms roomForms) {
        Room room = Room.builder()
                .name(roomForms.getName())
                .time(roomForms.getTime())
                .status(RoomStatus.INACTIVE)
                .build();
         repositories.save(room);
    }

    @Override
    public Room updateRoom(Long id, RoomForms updateForm) {
        Room room = repositories.getById(id);
        return repositories.save(room);
    }

    @Override
    public void deleteRoom(Long id) {
        Room room = repositories.getById(id);
        repositories.delete(room);
    }
}
