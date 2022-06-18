package com.local.conferencebooking.services;

import com.local.conferencebooking.forms.EventFormToCreateOrUpdate;
import com.local.conferencebooking.models.Event;
import org.springframework.ui.Model;

import java.time.LocalDateTime;

public interface EventService {
    Event getOne(Long id);

    Event createEvent(EventFormToCreateOrUpdate eventForm);

    Event updateEvent(Long id, EventFormToCreateOrUpdate updateForm);

    Event deleteEvent(Long id);

    Event checkingEvent(LocalDateTime date);

    boolean checking (EventFormToCreateOrUpdate eventForm, Model model);
}
