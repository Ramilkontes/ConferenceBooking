package com.local.conferencebooking.repositories;

import com.local.conferencebooking.models.ServiceClassForMeetRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<ServiceClassForMeetRoom, Long> {
}
