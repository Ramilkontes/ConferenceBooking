package com.local.conferencebooking.services;

import com.local.conferencebooking.exceptions.UsersNotFountException;
import com.local.conferencebooking.forms.UserForm;
import com.local.conferencebooking.models.Event;
import com.local.conferencebooking.models.EventStatus;
import com.local.conferencebooking.models.User;
import com.local.conferencebooking.repositories.EventRepositories;
import com.local.conferencebooking.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EventRepositories eventRepositories;

    @Autowired
    private MeetRoomService roomService;

    @Autowired
    private EventService eventService;

    @Override
    public List<User> findAll() {
        return repositories.findAll();
    }

    @Override
    public User findOne(Long id) {
        return repositories.findById(id).orElseThrow(UsersNotFountException::new);
    }

    @Override
    public User findOneByLogin(String login) {
        return repositories.findOneByLogin(login).orElseThrow(UsersNotFountException::new);
    }

    @Override
    public User updateUser(Long id, UserForm updateForm) {
        String hashPassword = passwordEncoder.encode(updateForm.getPassword());
        User user = findOne(id);
        user.setFirstName(updateForm.getFirstName());
        user.setLastName(updateForm.getLastName());
        user.setLogin(updateForm.getLogin());
        user.setHashPassword(hashPassword);
        return repositories.save(user);
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


    public boolean isPersonAbsentAtThisEvent(User user) {
        return eventRepositories.findAll().stream()
                .noneMatch(x -> x.getUsers().equals(user));
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
