package com.local.conferencebooking.controllers;

import com.local.conferencebooking.forms.EventForm;
import com.local.conferencebooking.models.Event;
import com.local.conferencebooking.services.EventService;
import com.local.conferencebooking.services.MeetRoomService;
import com.local.conferencebooking.services.ServiceClassForDate;
import com.local.conferencebooking.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService service;

    @Autowired
    private MeetRoomService roomService;

    @Autowired
    private UserService userService;

    @Autowired
    private ServiceClassForDate classForDate;

    @PostMapping()
    public String createEvent(@Valid EventForm eventForm, BindingResult bindingResult,
                              Model model) {
        if (bindingResult.hasErrors()) {
            getErrorsMap(bindingResult, model);
            getMainPage(eventForm, model);
            return "meet-room";
        } else if (!service.checkingForCreate(eventForm, model)) {
            getMainPage(eventForm, model);
            return "meet-room";
        } else {
            Event event = service.createEvent(eventForm);
            model.addAttribute("event", event);
            model.addAttribute("form", null);
            return "event";
        }
    }

    @PostMapping("/{id}")
    public String updateInformation(@PathVariable Long id,
                                    @Valid EventForm eventForm, BindingResult bindingResult,
                                    Model model) {
        if (bindingResult.hasErrors()) {
            getErrorsMap(bindingResult, model);
            model.addAttribute("form", eventForm);
            model.addAttribute("event", service.getOne(id));
            return "event";
        } else if (!service.checkingForUpdate(eventForm, model, service.getOne(id))) {
            model.addAttribute("event", service.getOne(id));
            return "event";
        }
        Event event = service.updateEvent(id, eventForm);
        model.addAttribute("event", event);
        return "eventEdit";
    }

    private void getErrorsMap(BindingResult bindingResult, Model model) {
        Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
        model.addAllAttributes(errorsMap);
    }

    private void getMainPage(EventForm eventForm, Model model) {
        model.addAttribute("form", eventForm);
        model.addAttribute("dateStart", LocalDateTime.now());
        model.addAttribute("dateFinish", LocalDateTime.now());
        List<LocalDate> week = roomService.getWeek(classForDate.getDate(1L));
        roomService.getModels(model, week);
    }
}
