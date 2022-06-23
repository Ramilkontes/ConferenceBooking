package com.local.conferencebooking.services;

import com.local.conferencebooking.forms.EventFormToCreateOrUpdate;
import com.local.conferencebooking.models.Event;
import org.springframework.ui.Model;

import java.time.LocalDateTime;

public interface EventService {
    Event getOne(Long id);

    Event createEvent(EventFormToCreateOrUpdate eventForm);

    Event updateEvent(Long id, EventFormToCreateOrUpdate updateForm);

    Event checkingEvent(LocalDateTime date);

    boolean checkingForCreate(EventFormToCreateOrUpdate eventForm, Model model);

    boolean checkingForUpdate(EventFormToCreateOrUpdate eventForm, Model model, Event event);
}
