package com.local.conferencebooking.services;

import com.local.conferencebooking.exceptions.RoomsNotFoundException;
import com.local.conferencebooking.exceptions.UsersNotFountException;
import com.local.conferencebooking.models.Desktop;
import com.local.conferencebooking.models.Room;
import com.local.conferencebooking.models.User;
import com.local.conferencebooking.repositories.DesktopRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesktopServiceImpl implements DesktopService {

    @Autowired
    private DesktopRepositories repositories;

    @Override
    public List<User> getAllPeople() {
        return repositories.findAll().stream()
                .map(Desktop::getUsers)
                .findAny().orElseThrow(UsersNotFountException::new);
    }

    @Override
    public List<Room> gerAllRooms() {
        return repositories.findAll().stream()
                .map(Desktop::getRooms)
                .findAny().orElseThrow(RoomsNotFoundException::new);
    }


}
