package com.local.conferencebooking.repositories;

import com.local.conferencebooking.models.MeetRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetRoomRepositories extends JpaRepository<MeetRoom, Long> {
}
