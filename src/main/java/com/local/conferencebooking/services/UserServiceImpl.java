package com.local.conferencebooking.services;

import com.local.conferencebooking.exceptions.RoomsNotFoundException;
import com.local.conferencebooking.forms.UserForm;
import com.local.conferencebooking.models.Room;
import com.local.conferencebooking.models.User;
import com.local.conferencebooking.repositories.RoomRepositories;
import com.local.conferencebooking.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepositories repositories;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoomRepositories roomRepositories;

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
    public ResponseEntity<Object> joinToRoom(Long id, String name) {
        User user = repositories.getById(id);
        Room room = roomRepositories.findRoomByName(name).orElseThrow(RoomsNotFoundException::new);
        room.getUsers().add(user);
        roomRepositories.save(room);
        user.getRooms().add(room);
        repositories.save(user);
        return ResponseEntity.ok().build();
    }
}
