package com.local.conferencebooking.repositories;

import com.local.conferencebooking.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepositories extends JpaRepository<Room, Long> {
}
