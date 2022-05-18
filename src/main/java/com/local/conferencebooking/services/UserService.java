package com.local.conferencebooking.services;

import com.local.conferencebooking.forms.UserForm;
import com.local.conferencebooking.models.Event;
import com.local.conferencebooking.models.User;

import java.time.LocalDateTime;
import java.util.List;

public interface UserService {
    List<User> findAll();

    User findOne(Long id);

    User findOneByLogin(String login);

    User updateUser(Long id, UserForm updateForm);

    Event joinToRoomByEventName(Long id, String name);

    Event joinToRoom(Long id, LocalDateTime eventForm) throws IllegalArgumentException;

    void setEventStatus(LocalDateTime fromForm, LocalDateTime today);

}
