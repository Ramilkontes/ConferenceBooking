package com.local.conferencebooking.repositories;

import com.local.conferencebooking.models.DayWeek;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<DayWeek, Long> {
}
