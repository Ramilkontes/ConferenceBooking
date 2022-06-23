package com.local.conferencebooking.services;

import com.local.conferencebooking.exceptions.UsersNotFountException;
import com.local.conferencebooking.models.Event;
import com.local.conferencebooking.models.User;
import com.local.conferencebooking.repositories.EventRepositories;
import com.local.conferencebooking.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepositories repositories;

    @Autowired
    private EventRepositories eventRepositories;

    @Autowired
    private EventService eventService;

    @Override
    public User findOneByLogin(String login) {
        return repositories.findOneByLogin(login).orElseThrow(UsersNotFountException::new);
    }

    @Override
    public void joinToRoom(Long id, LocalDateTime date, Model model) {
        User user = repositories.getById(id);
        Event event = eventService.checkingEvent(date);
        if (user.getEvents().contains(event)) {
            model.addAttribute("eventIsExist", true);
        } else {
            model.addAttribute("eventIsExist", null);
            addToEvent(user, event);
        }
    }

    private void addToEvent(User user, Event event) {
        event.getUsers().add(user);
        event.setAmountPeople(event.getUsers().size());
        eventRepositories.save(event);
        user.getEvents().add(event);
        repositories.save(user);
    }

    @Override
    public Map<String, Boolean> getFlagsByDays(List<LocalDate> dates) {
        Map<String, Boolean> flags = new HashMap<>();
        dates
                .forEach(x -> {
                    if (x.equals(LocalDate.now()) || x.isAfter(LocalDate.now())) {
                        flags.put(x.getDayOfWeek().toString(), true);
                    } else
                        flags.put(x.getDayOfWeek().toString(), false);
                });
        return flags;
    }
}
