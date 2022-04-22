package com.local.conferencebooking.services;

import com.local.conferencebooking.repositories.RoomRepositories;
import com.local.conferencebooking.repositories.UserRepositories;
import com.local.conferencebooking.transfer.AdminRoomsDto;
import com.local.conferencebooking.transfer.AdminUsersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import static com.local.conferencebooking.transfer.AdminUsersDto.*;
import static com.local.conferencebooking.transfer.AdminRoomsDto.*;

@Service
public class DesktopServiceImpl implements DesktopService {

    @Autowired
    private UserRepositories userRepositories;

    @Autowired
    private RoomRepositories roomRepositories;

    @Override
    public List<AdminUsersDto> getAllPeople() {
        return from(userRepositories.findAll());
    }

    @Override
    public List<AdminRoomsDto> gerAllRooms() {
        return from(roomRepositories.findAll());
    }

    @Override
    public LocalDate getTime(Date date) {
        return date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }


}
