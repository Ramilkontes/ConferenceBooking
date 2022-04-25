package com.local.conferencebooking.repositories;

import com.local.conferencebooking.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface EventRepositories extends JpaRepository<Event, Long> {
    Optional<Event> findRoomByName(String name);


    Optional<Event> findByDateStart(LocalDate date);
}
