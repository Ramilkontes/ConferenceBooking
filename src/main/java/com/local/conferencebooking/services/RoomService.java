package com.local.conferencebooking.services;

import com.local.conferencebooking.forms.RoomForm;
import com.local.conferencebooking.models.Room;

public interface RoomService {
    Room getOne(Long id);

    void createRoom(RoomForm roomForm);

    Room updateRoom(Long id, RoomForm updateForm);

    Room deleteRoom(Long id);
}
