package com.local.conferencebooking.controllers;

import com.local.conferencebooking.forms.EventFormToCreateOrUpdate;
import com.local.conferencebooking.models.Event;
import com.local.conferencebooking.models.User;
import com.local.conferencebooking.services.EventService;
import com.local.conferencebooking.services.MeetRoomService;
import com.local.conferencebooking.services.UserService;
import com.local.conferencebooking.transfer.EventDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

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

    @GetMapping()
    public String getInfo(HttpServletRequest request, Model model) {
        if (request.getParameterMap().containsKey("error")) {
            model.addAttribute("error", true);
            return "meet-room";
        }
        return "event";
    }


    @PostMapping()
    public String createEvent(@RequestParam String name,
                              @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateStart,
                              @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateFinish,
                              Model model, HttpServletRequest request) {
        User user = userService.findOneByLogin(request.getUserPrincipal().getName());
        Event event = service.createEvent(name, dateStart, dateFinish);
        roomService.saveIds(event.getId(), user.getId());
        model.addAttribute("success", true);
        model.addAttribute("event", event);
        return "event";
    }

    @GetMapping("/{id}")
    public String getEditForm() {
        return "eventEdit";
    }

    @PostMapping("/{id}")
    public String updateInformation(@PathVariable Long id,
                                    @RequestParam String name,
                                    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateStart,
                                    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateFinish,
                                    Model model, HttpServletRequest request) {
        Event event = saveUpdate(id, getEventFormToUpdate(name, dateStart, dateFinish));
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

    private EventFormToCreateOrUpdate getEventFormToUpdate(String name, LocalDateTime dateStart, LocalDateTime dateFinish) {
        EventFormToCreateOrUpdate updating = EventFormToCreateOrUpdate.builder()
                .name(name)
                .dateStart(dateStart)
                .dateFinish(dateFinish)
                .build();
        return updating;
    }
}
