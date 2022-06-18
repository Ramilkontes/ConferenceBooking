package com.local.conferencebooking.services;

import com.local.conferencebooking.models.Event;
import com.local.conferencebooking.models.User;
import com.local.conferencebooking.transfer.AdminEventsDto;
import org.springframework.ui.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface MeetRoomService {
    List<User> getAllPeople();

    List<AdminEventsDto> getAllRooms();

    LocalDateTime getTime();

    void saveIds(Long eventId, Long userId);

    Event findNewEvent(Long userId);

    List<LocalDate> getWeek(LocalDate date);

    List<LocalDate> getRequiredWeek(LocalDate day, Integer pointer);

    List<Event> getCurrentEvent (List<LocalDate> week);

    Map<String, List<Event>> getEventsByDay(List<LocalDate> week, List<Event> events);

    Map<String, Boolean> getEventsByTime (List<Event> events);

    void getModels(Model model, List<LocalDate> week);

    List<Event> getMyConcernments(Long id);
}
