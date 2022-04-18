package com.local.conferencebooking.services;

import com.local.conferencebooking.models.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findOne(Long id);
}
