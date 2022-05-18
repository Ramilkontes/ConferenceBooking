package com.local.conferencebooking.services;

import com.local.conferencebooking.forms.EventFormToCreateOrUpdate;
import com.local.conferencebooking.models.Event;

import java.time.LocalDateTime;

public interface EventService {
    Event getOne(Long id);

    Event createEvent(String name, LocalDateTime dateStart, LocalDateTime dateFinish);

    Event updateEvent(Long id, EventFormToCreateOrUpdate updateForm);

    Event deleteEvent(Long id);

    Event checkingEvent(LocalDateTime date);

    Event getInfoByUserId(Long user_id);
}
