package com.local.conferencebooking.services;

import com.local.conferencebooking.forms.EventForm;
import com.local.conferencebooking.models.Event;
import org.springframework.ui.Model;

import java.time.LocalDateTime;

public interface EventService {
    Event getOne(Long id);

    Event createEvent(EventForm eventForm);

    Event updateEvent(Long id, EventForm updateForm);

    Event checkingEvent(LocalDateTime date);

    boolean checkingForCreate(EventForm eventForm, Model model);

    boolean checkingForUpdate(EventForm eventForm, Model model, Event event);
}
