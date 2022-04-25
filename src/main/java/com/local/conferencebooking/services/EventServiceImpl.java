package com.local.conferencebooking.services;

import com.local.conferencebooking.forms.EventFormToCreate;
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
    public void createEvent(EventFormToCreate eventFormToCreate) {
        Event event = getEvent(eventFormToCreate);
        long minutes = getMinutes(eventFormToCreate);
        if (minutes >= 30 && minutes <= 1440) {
            getStatusEvent(event, roomService.getTime());
            repositories.save(event);
        }
        throw new IllegalArgumentException("Booking is not possible, please check entered date:" +
                "Minimum booking interval 30 minutes,\n" +
                "maximum 24 hours");
    }

    //TODO: Написать фильтрацию для проверки дат существующих событий
    /*private void checkBookingIsExist(Event event) {
        List<Event> events = repositories.findAll();
        if (event.getDateStart().isAfter(event.getDateFinish())) {

            events.stream().filter(x->x.getDateStart())
        }
    }*/

    private Event getEvent(EventFormToCreate eventFormToCreate) {
        return Event.builder()
                .name(eventFormToCreate.getName())
                .dateStart(eventFormToCreate.getDateStart())
                .dateFinish(eventFormToCreate.getDateFinish())
                .amountPeople(1)
                .status(EventStatus.INACTIVE)
                .build();
    }

    private long getMinutes(EventFormToCreate eventFormToCreate) {
        LocalDateTime start = eventFormToCreate.getDateStart().atStartOfDay();
        LocalDateTime finish = eventFormToCreate.getDateFinish().atStartOfDay();
        return ChronoUnit.MINUTES.between(start, finish);
    }

    private void getStatusEvent(Event event, LocalDate today) {
        if (event.getDateStart().compareTo(today) == 0) {
            event.setStatus(EventStatus.ACTIVE);
        }
        if (event.getDateStart().compareTo(today) > 0) {
            event.setStatus(EventStatus.CLOSED);
        }
    }

    @Override
    public Event updateEvent(Long id, EventFormToCreate updateForm) {
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

    public Event checkingEvent(LocalDate date) {
        return repositories.findByDateStart(date)
                .orElseThrow(() -> new IllegalArgumentException("Event is not found"));
    }
}
