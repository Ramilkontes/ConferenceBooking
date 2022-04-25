package com.local.conferencebooking.forms;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EventFormToCreate {
    private String name = "Event";
    private LocalDate dateStart;
    private LocalDate dateFinish;
}
