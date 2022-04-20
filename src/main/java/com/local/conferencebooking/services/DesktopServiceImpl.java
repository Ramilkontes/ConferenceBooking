package com.local.conferencebooking.services;

import com.local.conferencebooking.repositories.RoomRepositories;
import com.local.conferencebooking.repositories.UserRepositories;
import com.local.conferencebooking.transfer.RoomDto;
import com.local.conferencebooking.transfer.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import static com.local.conferencebooking.transfer.RoomDto.from;
import static com.local.conferencebooking.transfer.UserDto.from;


@Service
public class DesktopServiceImpl implements DesktopService {

    @Autowired
    private RoomRepositories roomRepositories;

    @Autowired
    private UserRepositories userRepositories;

    @Override
    public List<UserDto> getAllPeople() {
        return from(userRepositories.findAll());
    }

    @Override
    public List<RoomDto> gerAllRooms() {
        return from(roomRepositories.findAll());
    }

    @Override
    public LocalDate getTime(Date date) {
        return date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }


}
