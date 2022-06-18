package com.local.conferencebooking.services;

import com.local.conferencebooking.forms.EventFormToCreateOrUpdate;
import com.local.conferencebooking.models.Event;
import com.local.conferencebooking.models.EventStatus;
import com.local.conferencebooking.repositories.EventRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepositories repositories;

    @Autowired
    private MeetRoomService roomService;

    @Override
    public Event getOne(Long id) {
        return repositories.getById(id);
    }

    @Override
    public Event createEvent(EventFormToCreateOrUpdate eventForm) {
        Event event = buildNewEvent(eventForm.getName(), eventForm.getDateStart(), eventForm.getDateFinish());
        return repositories.save(event);
    }

    @Override
    public Event updateEvent(Long id, EventFormToCreateOrUpdate updateForm) {
        Event event = repositories.getById(id);
        event.setName(updateForm.getName());
        event.setDateStart(updateForm.getDateStart());
        event.setDateFinish(updateForm.getDateFinish());
        return repositories.save(event);
    }

    @Override
    public Event deleteEvent(Long id) {
        Optional<Event> room = repositories.findById(id);
        room.ifPresent(del -> repositories.delete(del));
        return room.get();
    }

    private Event buildNewEvent(String name, LocalDateTime dateStart, LocalDateTime dateFinish) {
        return Event.builder()
                .name(name)
                .dateStart(dateStart)
                .dateFinish(dateFinish)
                .status(EventStatus.INACTIVE)
                .build();
    }

    private boolean checkBookingToExist(EventFormToCreateOrUpdate eventForm) {
        Event event = buildNewEvent(eventForm.getName(), eventForm.getDateStart(), eventForm.getDateFinish());
        List<Event> events = repositories.findAll();
        LocalDateTime startNewEvent = event.getDateStart();
        LocalDateTime finishNewEvent = event.getDateFinish();
        if (events.stream().anyMatch(x -> x.getDateStart().isAfter(startNewEvent)
                && x.getDateStart().isBefore(finishNewEvent))) {
            return false;
        } else if (events.stream().anyMatch(x -> x.getDateFinish().isAfter(startNewEvent)
                && x.getDateFinish().isBefore(finishNewEvent))) {
            return false;
        } else if (events.stream().anyMatch(x -> x.getDateStart().equals(startNewEvent)
                || x.getDateFinish().equals(finishNewEvent))) {
            return false;
        }
        return true;
    }

    private boolean checkingToCorrectForm(EventFormToCreateOrUpdate eventForm) {
        long minutes = getMinutes(eventForm.getDateStart(), eventForm.getDateFinish());
        if (minutes >= 30 && minutes <= 1440) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean checking (EventFormToCreateOrUpdate eventForm, Model model) {
        if (!checkBookingToExist(eventForm)) {
            model.addAttribute("engagedTime", "Booking is not possible, this time is engaged");
            return false;
        } else if (!checkingToCorrectForm(eventForm)) {
            model.addAttribute("notCorrectness", "Booking is not possible, please check entered date: " +
                    "Minimum booking interval 30 minutes, maximum - 24 hours");
            return false;
        } else return true;
    }

    private long getMinutes(LocalDateTime start, LocalDateTime finish) {
        return ChronoUnit.MINUTES.between(start, finish);
    }

    private Event getStatusEvent(Event event) {
        LocalDate startDate = event.getDateStart().toLocalDate();
        LocalDate todayDate = roomService.getTime().toLocalDate();
        if (startDate.compareTo(todayDate) == 0) {
            event.setStatus(EventStatus.ACTIVE);
        }
        if (startDate.compareTo(todayDate) < 0) {
            event.setStatus(EventStatus.CLOSED);
        }
        return event;
    }

    public Event checkingEvent(LocalDateTime date) {
        return repositories.findFirstByDateStart(date)
                .orElseThrow(() -> new IllegalArgumentException("Event is not found"));
    }

}
