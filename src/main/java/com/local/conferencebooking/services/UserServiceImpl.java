package com.local.conferencebooking.services;

import com.local.conferencebooking.exceptions.EventNotFoundException;
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

import java.time.LocalDateTime;
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
    public Event joinToRoom(Long id, LocalDateTime date) throws IllegalArgumentException {
        User user = repositories.getById(id);
        Event event = eventService.checkingEvent(date);
        if (isPersonAbsentAtThisEvent(user)) {
            return getEvent(user, event);
        } else
            throw new IllegalArgumentException("U have already registered");
    }

    @Override
    public Event joinToRoomByEventName(Long id, String name) {
        User user = repositories.getById(id);
        Event event = eventRepositories.findFirstByNameAndStatus(name, EventStatus.ACTIVE)
                .orElseThrow(EventNotFoundException::new);
        if (isPersonAbsentAtThisEvent(user)) {
            if (event.getDateStart().getYear() == roomService.getTime().getYear()) {
                return getEvent(user, event);
            } else
                throw new IllegalArgumentException("Joining already closed, check information relevance");
        } else
            throw new IllegalArgumentException("U have already registered");
    }

    private Event getEvent(User user, Event event) {
        setEventStatus(event.getDateStart(), roomService.getTime());
        event.getUsers().add(user);
        event.setAmountPeople(event.getUsers().size());
        eventRepositories.save(event);
        user.getEvents().add(event);
        repositories.save(user);
        return event;
    }

    public void setEventStatus(LocalDateTime fromForm, LocalDateTime today) {
        Event event = eventService.checkingEvent(fromForm);
        if (fromForm.getDayOfYear() == today.getDayOfYear()) {
            event.setStatus(EventStatus.ACTIVE);
  //          eventRepositories.save(event);
        } else if (fromForm.getDayOfYear() > today.getDayOfYear()) {
            event.setStatus(EventStatus.INACTIVE);
  //          eventRepositories.save(event);
            throw new IllegalArgumentException("Joining to this event is not unable, " +
                    "event still inactive");
        } else {
            event.setStatus(EventStatus.CLOSED);
//            eventRepositories.save(event);
            throw new IllegalArgumentException("Joining to this event is not unable, " +
                    "event already closed");
        }
        eventRepositories.save(event);
    }

    private boolean isPersonAbsentAtThisEvent(User user) {
        return eventRepositories.findAll().stream()
                .noneMatch(x -> x.getUsers().equals(user));
    }

//TODO: тот кто создает сразу добавляется в комнату

//TODO: добавить автообновление таблицы эвентов, а именно статусы бронирования
}
