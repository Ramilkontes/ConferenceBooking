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

    List<LocalDate> getWeek(LocalDate date);

    LocalDateTime getRequiredDate(LocalDateTime day, Integer pointer);

    Map<String, List<Event>> getEventsByDay(List<LocalDate> week, List<Event> events);

    Map<String, Boolean> getEventsByTime (List<Event> events);

    void getModels(Model model, LocalDateTime date);

    List<Event> getMyConcernments(Long id);

    List<Event> findEventsOfCurrentWeek(LocalDateTime currentDate);
}
