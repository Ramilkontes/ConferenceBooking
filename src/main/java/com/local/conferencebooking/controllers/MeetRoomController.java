package com.local.conferencebooking.controllers;

import com.local.conferencebooking.security.details.UserDetailsImpl;
import com.local.conferencebooking.services.MeetRoomService;
import com.local.conferencebooking.transfer.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import static com.local.conferencebooking.transfer.UserDto.from;

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

    @GetMapping("/")
    public String getProfilePage(ModelMap model, Authentication authentication) {
        if (authentication == null) {
            return "redirect:/login";
        }
        UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
        UserDto user = from(details.getUser());
        model.addAttribute("user", user);
        return "meet-room";

    }
/*
    @GetMapping
    public LocalDateTime getTimeToday() {
        return service.getTime();
    }
*/
}
