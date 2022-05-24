package com.local.conferencebooking.services;

import com.local.conferencebooking.models.Event;
import com.local.conferencebooking.models.MeetRoom;
import com.local.conferencebooking.models.User;
import com.local.conferencebooking.repositories.EventRepositories;
import com.local.conferencebooking.repositories.MeetRoomRepositories;
import com.local.conferencebooking.repositories.UserRepositories;
import com.local.conferencebooking.transfer.AdminEventsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

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
    @Override
    public List<LocalDate> getWeek(LocalDate dateParam){
        List<LocalDate> weekDayList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        Date date = Date.from(dateParam.atStartOfDay(ZoneId.systemDefault()).toInstant());
        cal.setTime(date);
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        int day = cal.get(Calendar.DAY_OF_WEEK);
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
        weekDayList.add(cal.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        cal.add(Calendar.DATE, 1);
        weekDayList.add(cal.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        cal.add(Calendar.DATE, 1);
        weekDayList.add(cal.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        cal.add(Calendar.DATE, 1);
        weekDayList.add(cal.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        cal.add(Calendar.DATE, 1);
        weekDayList.add(cal.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        cal.add(Calendar.DATE, 1);
        weekDayList.add(cal.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        cal.add(Calendar.DATE, 1);
        weekDayList.add(cal.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        return weekDayList;
    }
}
