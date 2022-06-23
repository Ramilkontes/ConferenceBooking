package com.local.conferencebooking.repositories;

import com.local.conferencebooking.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface EventRepositories extends JpaRepository<Event, Long> {

    Optional<Event> findFirstByDateStart(LocalDateTime date);

}
