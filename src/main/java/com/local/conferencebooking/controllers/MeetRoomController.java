package com.local.conferencebooking.controllers;

import com.local.conferencebooking.forms.EventFormToCreateOrUpdate;
import com.local.conferencebooking.services.MeetRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MeetRoomController {

    private LocalDate dayWeek;

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

    @GetMapping("/")
    public String getMainPage(@Valid EventFormToCreateOrUpdate eventForm, Model model, Authentication authentication) {
        if (authentication == null) {
            return "redirect:/login";
        }
        /*UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
        UserDto user = from(details.getUser());
        model.addAttribute("user", user);*/

        if (model.containsAttribute("flag")) {
            model.addAttribute("week", service.getWeek(dayWeek));
            model.addAttribute("flag", null);
        } else {
            List<LocalDate> week = service.getWeek(LocalDate.now());
            dayWeek = week.get(0);
            model.addAttribute("week", week);
        }
        if (!model.containsAttribute("form")) {
            model.addAttribute("event", eventForm);
        }
        return "meet-room";
    }

    @PostMapping("/")
    public String getPreviousOrNextWeek(@RequestParam Integer pointer, Model model) {
        List<LocalDate> requiredWeek = getRequiredWeek(dayWeek, pointer);
        model.addAttribute("week", requiredWeek);
        model.addAttribute("flag", true);
        return "meet-room";
    }

    private List<LocalDate> getRequiredWeek(LocalDate day, Integer pointer) {
        List<LocalDate> date;
        if (pointer < 0) {
            date = service.getWeek(day.minusWeeks(1));
            dayWeek = date.get(0);
            return date;
        } else {
            date = service.getWeek(day.plusWeeks(1));
            dayWeek = date.get(0);
            return date;

        }
    }
}
