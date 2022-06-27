package com.local.conferencebooking.services;

import java.time.LocalDate;

public interface ServiceClassForDate {

    LocalDate getDate (Long id);

    void updateDate(Long id, LocalDate date);
}
