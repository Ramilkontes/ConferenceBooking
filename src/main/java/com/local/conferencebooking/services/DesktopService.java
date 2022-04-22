package com.local.conferencebooking.services;

import com.local.conferencebooking.transfer.AdminRoomsDto;
import com.local.conferencebooking.transfer.AdminUsersDto;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface DesktopService {
    List<AdminUsersDto> getAllPeople();

    List<AdminRoomsDto> gerAllRooms();

    LocalDate getTime(Date date);
}
