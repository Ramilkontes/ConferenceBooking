package com.local.conferencebooking.services;

import com.local.conferencebooking.transfer.AdminEventsDto;
import com.local.conferencebooking.transfer.AdminUsersDto;

import java.time.LocalDate;
import java.util.List;

public interface MeetRoomService {
    List<AdminUsersDto> getAllPeople();

    List<AdminEventsDto> gerAllRooms();

    LocalDate getTime();
}
