package com.local.conferencebooking.services;

import com.local.conferencebooking.forms.EventFormToCreate;
import com.local.conferencebooking.models.Event;

import java.time.LocalDate;

public interface EventService {
    Event getOne(Long id);

    void createEvent(EventFormToCreate eventFormToCreate);

    Event updateEvent(Long id, EventFormToCreate updateForm);

    Event deleteEvent(Long id);

    Event checkingEvent(LocalDate date);
}
