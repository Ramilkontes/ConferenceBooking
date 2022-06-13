package com.local.conferencebooking.controllers;

import com.local.conferencebooking.forms.EventFormToCreateOrUpdate;
import com.local.conferencebooking.models.Event;
import com.local.conferencebooking.services.MeetRoomService;
import com.local.conferencebooking.services.ServiceClassForDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MeetRoomController {

    @Autowired
    private MeetRoomService service;

    @Autowired
    private ServiceClassForDate classForDate;

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
    public String getMainPage(Model model, Authentication authentication) {
        if (authentication == null) {
            return "redirect:/login";
        }
        /*UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
        UserDto user = from(details.getUser());
        model.addAttribute("user", user);*/
        List<LocalDate> week;
        if (model.containsAttribute("flag")) {
            week = service.getWeek(classForDate.getDate(1L));
            model.addAttribute("flag", null);
        } else {
            week = service.getWeek(LocalDate.now());
            classForDate.updateDate(1L, week.get(0));
        }
        /*if (model.containsAttribute("form")) {
            model.addAttribute("event", eventForm);
        }*/
        model.addAttribute("week", week);
        service.getModels(model, week);
        return "meet-room";
    }



    @PostMapping("/")
    public String getPreviousOrNextWeek(@RequestParam Integer pointer, Model model) {
        List<LocalDate> week = service.getRequiredWeek(classForDate.getDate(1L), pointer);
        model.addAttribute("week", week);
        model.addAttribute("flag", true);
        service.getModels(model, week);
        return "meet-room";
    }
}
