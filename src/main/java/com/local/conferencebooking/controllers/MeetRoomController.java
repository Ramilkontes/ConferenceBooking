package com.local.conferencebooking.controllers;

import com.local.conferencebooking.security.details.UserDetailsImpl;
import com.local.conferencebooking.services.MeetRoomService;
import com.local.conferencebooking.services.ServiceClassForDate;
import com.local.conferencebooking.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class MeetRoomController {

    @Autowired
    private MeetRoomService service;

    @Autowired
    private ServiceClassForDate classForDate;

    @Autowired
    private UserService userService;

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
  //      UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
        List<LocalDate> week;
        if (model.containsAttribute("mark")) {
            week = service.getWeek(classForDate.getDate(1L));
            model.addAttribute("mark", null);
        } else {
            week = service.getWeek(LocalDate.now());
            classForDate.updateDate(1L, week.get(0));
        }
        model.addAttribute("week", week);
        service.getModels(model, week);
        return "meet-room";
    }


    @PostMapping("/")
    public String getPreviousOrNextWeek(@RequestParam Integer pointer, Model model) {
        List<LocalDate> week = service.getRequiredWeek(classForDate.getDate(1L), pointer);
        model.addAttribute("week", week);
        model.addAttribute("mark", true);
        service.getModels(model, week);
        return "meet-room";
    }
}
