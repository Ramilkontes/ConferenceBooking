package com.local.conferencebooking.services;

import com.local.conferencebooking.models.Event;
import com.local.conferencebooking.models.MeetRoom;
import com.local.conferencebooking.models.ServiceClassForMeetRoom;
import com.local.conferencebooking.models.User;
import com.local.conferencebooking.repositories.EventRepositories;
import com.local.conferencebooking.repositories.MeetRoomRepositories;
import com.local.conferencebooking.repositories.UserRepositories;
import com.local.conferencebooking.transfer.AdminEventsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static com.local.conferencebooking.transfer.AdminEventsDto.*;

@Service
public class MeetRoomServiceImpl implements MeetRoomService {

    @Autowired
    private UserRepositories userRepositories;

    @Autowired
    private EventRepositories eventRepositories;

    @Autowired
    private MeetRoomRepositories repositories;

    @Override
    public List<User> getAllPeople() {
        return userRepositories.findAll();
    }

    @Override
    public List<AdminEventsDto> getAllRooms() {
        return from(eventRepositories.findAll());
    }

    @Override
    public LocalDateTime getTime() {
        return LocalDateTime.now();
    }

    @Override
    public void saveIds(Long eventId, Long userId) {
        MeetRoom room = MeetRoom.builder()
                .userId(userId)
                .eventId(eventId)
                .build();
        repositories.save(room);
    }

    public Event findNewEvent(Long userId) {
        MeetRoom meetRoom = repositories.findAll().stream()
                .filter(x -> x.getUserId().equals(userId))
                .reduce((first, second) -> second)
                .get();

        return eventRepositories.getById(meetRoom.getEventId());
    }
}
