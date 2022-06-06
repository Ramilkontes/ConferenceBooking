package com.local.conferencebooking.services;

import com.local.conferencebooking.models.ServiceClassForMeetRoom;
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
        ServiceClassForMeetRoom serviceClassForMeetRoom= repository.getById(id);
        serviceClassForMeetRoom.setDayWeek(localDate);
        repository.save(serviceClassForMeetRoom);
    }


}
