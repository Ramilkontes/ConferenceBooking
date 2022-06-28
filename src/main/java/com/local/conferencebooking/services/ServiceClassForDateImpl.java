package com.local.conferencebooking.services;

import com.local.conferencebooking.models.DayWeek;
import com.local.conferencebooking.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ServiceClassForDateImpl implements ServiceClassForDate {

    @Autowired
    private ServiceRepository repository;

    @Override
    public LocalDate getDate (Long id){
        return repository.getById(id).getDayWeek();
    }

    @Override
    public void updateDate(Long id, LocalDate localDate) {
        DayWeek dayWeek = repository.getById(id);
        dayWeek.setDayWeek(localDate);
        repository.save(dayWeek);
    }


}
