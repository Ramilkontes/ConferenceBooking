package com.local.conferencebooking.controllers;

import com.local.conferencebooking.forms.CalendarForm;
import com.local.conferencebooking.services.MeetRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
public class MeetRoomController {

    @Autowired
    private MeetRoomService service;

    @GetMapping("/meet-room/people")
    public String getAllPeople(Model model) {
        model.addAttribute("users", service.getAllPeople());
        return "userList";
    }

    @GetMapping("/meet-room/rooms")
    public String getAllRooms(Model model) {
        model.addAttribute("events", service.getAllRooms());
        return "eventsList";
    }

    @GetMapping("/meet-room/events/{id}")
    public String getMyEvents(@PathVariable Long id, Model model) {
        model.addAttribute("concernments", service.getMyConcernments(id));
        return "myConcernments";
    }

    @GetMapping("/")
    public String getMainPage(Model model, Authentication authentication) {
        if (authentication == null) {
            return "redirect:/login";
        }
        LocalDateTime now = LocalDateTime.now();
        model.addAttribute("currentDate", now);
        service.getModels(model, now);
        return "meet-room";
    }

    @PostMapping("/")
    public String getPreviousOrNextWeek(CalendarForm calendarForm,
                                        Model model) {
        LocalDateTime requiredDate = service.getRequiredDate(calendarForm.getCurrentDate(), calendarForm.getPointer());
        model.addAttribute("currentDate", requiredDate);
        service.getModels(model, requiredDate);
        return "meet-room";
    }
}
