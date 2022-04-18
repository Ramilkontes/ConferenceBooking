package com.local.conferencebooking.services;

import com.local.conferencebooking.forms.RoomForms;
import com.local.conferencebooking.models.Room;

public interface RoomService {
    Room getOne(Long id);

    void createRoom(RoomForms roomForms);

    Room updateRoom(Long id, RoomForms updateForm);

    void deleteRoom(Long id);
}
