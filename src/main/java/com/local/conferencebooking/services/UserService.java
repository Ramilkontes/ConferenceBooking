package com.local.conferencebooking.services;

import com.local.conferencebooking.forms.EventFormToFindByDate;
import com.local.conferencebooking.forms.UserForm;
import com.local.conferencebooking.models.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findOne(Long id);

    User updateUser(Long id, UserForm updateForm);

    ResponseEntity<Object> joinToRoomByEventName(Long id, String name);

    ResponseEntity<Object> joinToRoom(Long id, EventFormToFindByDate eventForm) throws IllegalArgumentException;
}
