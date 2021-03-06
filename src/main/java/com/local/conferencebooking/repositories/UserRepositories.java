package com.local.conferencebooking.repositories;

import com.local.conferencebooking.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepositories extends JpaRepository<User, Long> {
    Optional<User> findOneByLogin(String login);
}
