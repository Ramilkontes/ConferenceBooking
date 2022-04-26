package com.local.conferencebooking.services;

import com.local.conferencebooking.repositories.EventRepositories;
import com.local.conferencebooking.repositories.UserRepositories;
import com.local.conferencebooking.transfer.AdminEventsDto;
import com.local.conferencebooking.transfer.AdminUsersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static com.local.conferencebooking.transfer.AdminUsersDto.*;
import static com.local.conferencebooking.transfer.AdminEventsDto.*;

@Service
public class MeetRoomServiceImpl implements MeetRoomService {

    @Autowired
    private UserRepositories userRepositories;

    @Autowired
    private EventRepositories eventRepositories;

    @Override
    public List<AdminUsersDto> getAllPeople() {
        return from(userRepositories.findAll());
    }

    @Override
    public List<AdminEventsDto> gerAllRooms() {
        return from(eventRepositories.findAll());
    }

    @Override
    public LocalDateTime getTime() {
        return LocalDateTime.now();
    }
}
