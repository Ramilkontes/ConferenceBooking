package com.local.conferencebooking.services;

import com.local.conferencebooking.forms.EventForm;
import com.local.conferencebooking.models.Event;
import com.local.conferencebooking.models.EventStatus;
import com.local.conferencebooking.repositories.EventRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

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
    public Event createEvent(EventForm eventForm) {
        Event event = buildNewEvent(eventForm.getName(), eventForm.getDateStart(), eventForm.getDateFinish());
        setEventStatus(eventForm.getDateStart(), LocalDateTime.now(), event);
        return repositories.save(event);
    }

    @Override
    public Event updateEvent(Long id, EventForm updateForm) {
        Event event = repositories.getById(id);
        setEventStatus(updateForm.getDateStart(), LocalDateTime.now(), event);
        event.setName(updateForm.getName());
        event.setDateStart(updateForm.getDateStart());
        event.setDateFinish(updateForm.getDateFinish());
        return repositories.save(event);
    }

    @Override
    public boolean checkingForCreate(EventForm eventForm, Model model) {
        if (standardChecking(eventForm, model)) return false;
        if (!checkBookingToExistForCreate(eventForm)) {
            model.addAttribute("engagedTime", "Booking is not possible, this time is engaged");
            return false;
        } else return true;
    }

    @Override
    public boolean checkingForUpdate(EventForm eventForm, Model model, Event oldEvent) {
        if (standardChecking(eventForm, model)) return false;
        if (!checkBookingToExistForUpdate(eventForm, oldEvent)) {
            model.addAttribute("engagedTime", "Booking is not possible, this time is engaged");
            return false;
        }
        return true;
    }

    public void setEventStatus(LocalDateTime fromForm, LocalDateTime today, Event event) {
        if (fromForm.getDayOfYear() == today.getDayOfYear()) {
            event.setStatus(EventStatus.ACTIVE);
        } else if (fromForm.getDayOfYear() > today.getDayOfYear()) {
            event.setStatus(EventStatus.INACTIVE);
        }
    }

    private Event buildNewEvent(String name, LocalDateTime dateStart, LocalDateTime dateFinish) {
        return Event.builder()
                .name(name)
                .dateStart(dateStart)
                .dateFinish(dateFinish)
                .status(EventStatus.INACTIVE)
                .build();
    }

    private boolean checkingToCorrectForm(EventForm eventForm) {
        long minutes = getMinutes(eventForm.getDateStart(), eventForm.getDateFinish());
        if (minutes >= 30 && minutes <= 1440) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkBookingToExistForCreate(EventForm eventForm) {
        Event event = buildNewEvent(eventForm.getName(), eventForm.getDateStart(), eventForm.getDateFinish());
        List<Event> events = repositories.findAll();
        LocalDateTime startNewEvent = event.getDateStart();
        LocalDateTime finishNewEvent = event.getDateFinish();
        return checkingEngagedTime(events, startNewEvent, finishNewEvent);
    }

    private boolean checkBookingToExistForUpdate(EventForm eventForm, Event oldEvent) {
        List<Event> events = repositories.findAll();
        events.remove(oldEvent);
        LocalDateTime startNewEvent = eventForm.getDateStart();
        LocalDateTime finishNewEvent = eventForm.getDateFinish();
        return checkingEngagedTime(events, startNewEvent, finishNewEvent);
    }

    private boolean checkingEngagedTime(List<Event> events, LocalDateTime startNewEvent, LocalDateTime finishNewEvent) {
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

    private boolean standardChecking(EventForm eventForm, Model model) {
        if (eventForm.getDateStart().isAfter(eventForm.getDateFinish())) {
            model.addAttribute("notCorrectness", "Time start mustn't be after time finish");
            return true;
        }
        if (!checkingToCorrectForm(eventForm)) {
            model.addAttribute("notCorrectness", "Booking is not possible, please check entered date: " +
                    "Minimum booking interval 30 minutes, maximum - 24 hours");
            return true;
        }
        return false;
    }

    private long getMinutes(LocalDateTime start, LocalDateTime finish) {
        return ChronoUnit.MINUTES.between(start, finish);
    }

    public Event checkingEvent(LocalDateTime date) {
        return repositories.findFirstByDateStart(date)
                .orElseThrow(() -> new IllegalArgumentException("Event is not found"));
    }
}
