package com.local.conferencebooking.services;

import com.local.conferencebooking.forms.EventFormToCreateOrUpdate;
import com.local.conferencebooking.models.Event;
import com.local.conferencebooking.models.EventStatus;
import com.local.conferencebooking.repositories.EventRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
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
    public Event createEvent(String name, LocalDateTime dateStart, LocalDateTime dateFinish) {
        Event event = buildNewEvent(name, dateStart, dateFinish);
        checkBookingToExist(event);
        long minutes = getMinutes(dateStart, dateFinish);
        if (minutes >= 30 && minutes <= 1440) {
            return event;
        } else {
            throw new IllegalArgumentException("Booking is not possible, please check entered date:" +
                    "Minimum booking interval 30 minutes,\n" +
                    "maximum 24 hours");
        }
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
        if(name==null) {
            name = "Event";
        }
        return Event.builder()
                .name(name)
                .dateStart(dateStart)
                .dateFinish(dateFinish)
                .status(EventStatus.INACTIVE)
                .build();
    }

    private void checkBookingToExist(Event event) {
        List<Event> events = repositories.findAll();
        LocalDateTime startNewEvent = event.getDateStart();
        LocalDateTime finishNewEvent = event.getDateFinish();
        if (events.stream().anyMatch(x -> x.getDateStart().isAfter(startNewEvent)
                && x.getDateStart().isBefore(finishNewEvent))) {
            throw new IllegalArgumentException("Booking is not possible, this time is engaged");
        } else if (events.stream().anyMatch(x -> x.getDateFinish().isAfter(startNewEvent)
                && x.getDateFinish().isBefore(finishNewEvent))) {
            throw new IllegalArgumentException("Booking is not possible, this time is engaged");
        } else if (events.stream().anyMatch(x -> x.getDateStart().equals(startNewEvent)
                || x.getDateFinish().equals(finishNewEvent))) {
            throw new IllegalArgumentException("Booking is not possible, this time is engaged");
        }
    }

    //TODO: написать првоерку на корректность введения формы даты для создания бронирования

    private long getMinutes(LocalDateTime start, LocalDateTime finish) {
/*        LocalDateTime start = eventFormToCreate.getDateStart();
        LocalDateTime finish = eventFormToCreate.getDateFinish();*/
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

    @Override
    public Event getInfoByUserId(Long userId) {
        return roomService.findNewEvent(userId);
    }
}
