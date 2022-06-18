package com.local.conferencebooking.controllers;

import com.local.conferencebooking.forms.EventFormToCreateOrUpdate;
import com.local.conferencebooking.models.Event;
import com.local.conferencebooking.models.User;
import com.local.conferencebooking.services.EventService;
import com.local.conferencebooking.services.MeetRoomService;
import com.local.conferencebooking.services.ServiceClassForDate;
import com.local.conferencebooking.services.UserService;
import com.local.conferencebooking.transfer.EventDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static com.local.conferencebooking.transfer.EventDto.from;

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


    @GetMapping()
    public String getInfo(HttpServletRequest request, Model model) {
        if (request.getParameterMap().containsKey("error")) {
            model.addAttribute("error", true);
            return "meet-room";
        }
        return "event";
    }


    @PostMapping()
    public String createEvent(@Valid EventFormToCreateOrUpdate eventForm, BindingResult bindingResult,
                              Model model, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
            model.addAllAttributes(errorsMap);
            getMainPage(eventForm, model);
            return "meet-room";
        } else if (!service.checking(eventForm, model)) {
            getMainPage(eventForm, model);
            return "meet-room";
        } else {
            User user = userService.findOneByLogin(request.getUserPrincipal().getName());
            Event event = service.createEvent(eventForm);
            roomService.saveIds(event.getId(), user.getId());
            model.addAttribute("success", true);
            model.addAttribute("event", event);
            model.addAttribute("form", null);
            model.addAttribute("engagedTime", null);
            model.addAttribute("notCorrectness", null);
            return "event";
        }
    }

    private void getMainPage(EventFormToCreateOrUpdate eventForm, Model model) {
        model.addAttribute("form", eventForm);
        model.addAttribute("dateStart", LocalDateTime.now());
        model.addAttribute("dateFinish", LocalDateTime.now());
        List<LocalDate> week = roomService.getWeek(classForDate.getDate(1L));
        model.addAttribute("week", week);
        roomService.getModels(model, week);
    }

    @GetMapping("/{id}")
    public String getEditForm() {
        return "eventEdit";
    }

    @PostMapping("/{id}")
    public String updateInformation(@PathVariable Long id,
                                    @Valid EventFormToCreateOrUpdate eventForm, BindingResult bindingResult,
                                    Model model, HttpServletRequest request) {
        Event event = saveUpdate(id, eventForm);
        model.addAttribute("event", event);
        return "eventEdit";
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EventDto> deleteRoom(@PathVariable Long id) {
        if (checkForExists(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(from(service.deleteEvent(id)), HttpStatus.OK);
    }

    private Event checkForExists(Long id) {
        return service.getOne(id);
    }

    private Event saveUpdate(Long eventId, EventFormToCreateOrUpdate updateForm) {
        return service.updateEvent(eventId, updateForm);

    }

    private EventFormToCreateOrUpdate getEventFormToUpdate(String name, LocalDateTime dateStart, LocalDateTime
            dateFinish) {
        EventFormToCreateOrUpdate updating = EventFormToCreateOrUpdate.builder()
                .name(name)
                .dateStart(dateStart)
                .dateFinish(dateFinish)
                .build();
        return updating;
    }
}
