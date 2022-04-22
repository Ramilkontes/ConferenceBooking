package com.local.conferencebooking.repositories;

import com.local.conferencebooking.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomRepositories extends JpaRepository<Room, Long> {
    Optional<Room> findRoomByName(String name);
}
