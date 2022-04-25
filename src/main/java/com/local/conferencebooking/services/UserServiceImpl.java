package com.local.conferencebooking.services;

import com.local.conferencebooking.exceptions.EventNotFoundException;
import com.local.conferencebooking.forms.EventFormToFindByDate;
import com.local.conferencebooking.forms.UserForm;
import com.local.conferencebooking.models.Event;
import com.local.conferencebooking.models.EventStatus;
import com.local.conferencebooking.models.User;
import com.local.conferencebooking.repositories.EventRepositories;
import com.local.conferencebooking.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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
        return repositories.getById(id);
    }

    @Override
    public User updateUser(Long id, UserForm updateForm) {
        String hashPassword = passwordEncoder.encode(updateForm.getPassword());
        User user = findOne(id);
        user.setFirsName(updateForm.getFirstName());
        user.setLastName(updateForm.getLastName());
        user.setLogin(updateForm.getLogin());
        user.setHashPassword(hashPassword);
        return repositories.save(user);
    }

    @Override
    public ResponseEntity<Object> joinToRoomByEventName(Long id, String name) {
        User user = repositories.getById(id);
        Event event = eventRepositories.findRoomByName(name).orElseThrow(EventNotFoundException::new);
        LocalDate fromForm = event.getDateStart();
        LocalDate today = roomService.getTime();
        if (fromForm.getDayOfYear() == today.getDayOfYear()) {
            event.getUsers().add(user);
            eventRepositories.save(event);
            user.getEvents().add(event);
            repositories.save(user);
            return ResponseEntity.ok().build();
        }
        return getHttpStatus(fromForm, today, event);
    }

    @Override
    public ResponseEntity<Object> joinToRoom(Long id, EventFormToFindByDate eventForm) throws IllegalArgumentException {
        User user = repositories.getById(id);
        LocalDate fromForm = eventForm.getDate();
        LocalDate today = roomService.getTime();
        Event event = eventService.checkingEvent(fromForm);
        if (fromForm.getYear() == today.getYear()) {
            if (fromForm.getDayOfYear() == today.getDayOfYear()) {
                event.getUsers().add(user);
                eventRepositories.save(event);
                user.getEvents().add(event);
                repositories.save(user);
            } else if (fromForm.getDayOfYear() > today.getDayOfYear()) {
                eventRepositories.save(event);
            } else {
                eventRepositories.save(event);
            }
            return getHttpStatus(fromForm, today, event);
        }
        throw new IllegalArgumentException("Joining to this event is not unable, please check entered date");
    }

    public ResponseEntity<Object> getHttpStatus(LocalDate date, LocalDate today, Event event) {
        if (date.getYear() == today.getYear()) {
            if (date.getDayOfYear() == today.getDayOfYear()) {
                event.setStatus(EventStatus.ACTIVE);
                return new ResponseEntity<>(HttpStatus.ACCEPTED);
            } else if (date.getDayOfYear() > today.getDayOfYear()) {
                event.setStatus(EventStatus.INACTIVE);
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            } else {
                event.setStatus(EventStatus.CLOSED);
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
//TODO: проверка на время бронирования 30 минут/24 часа

//TODO: сделать админу метод для моментальной установки CLOSED для всех закончнных событий