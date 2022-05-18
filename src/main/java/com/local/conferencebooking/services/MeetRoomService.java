package com.local.conferencebooking.services;

import com.local.conferencebooking.models.Event;
import com.local.conferencebooking.models.User;
import com.local.conferencebooking.transfer.AdminEventsDto;

import java.time.LocalDateTime;
import java.util.List;

public interface MeetRoomService {
    List<User> getAllPeople();

    List<AdminEventsDto> getAllRooms();

    LocalDateTime getTime();

    void saveIds(Long eventId, Long userId);
    Event findNewEvent(Long userId);
}
