package com.local.conferencebooking.services;

import com.local.conferencebooking.transfer.RoomDto;
import com.local.conferencebooking.transfer.UserDto;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface DesktopService {
    List<UserDto> getAllPeople();

    List<RoomDto> gerAllRooms();

    LocalDate getTime(Date date);
}
