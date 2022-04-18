package com.local.conferencebooking.forms;

import lombok.Data;

import java.sql.Time;

@Data
public class RoomForms {
    private String name;
    private Time time;
}
