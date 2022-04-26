package com.local.conferencebooking.services;

import com.local.conferencebooking.transfer.AdminEventsDto;
import com.local.conferencebooking.transfer.AdminUsersDto;

import java.time.LocalDateTime;
import java.util.List;

public interface MeetRoomService {
    List<AdminUsersDto> getAllPeople();

    List<AdminEventsDto> gerAllRooms();

    LocalDateTime getTime();
}
