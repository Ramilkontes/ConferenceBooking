package com.local.conferencebooking.forms;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class EventFormToCreate {
    private String name;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm", shape = JsonFormat.Shape.STRING)
    @JsonProperty(value = "date_start")
    private LocalDateTime dateStart;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm", shape = JsonFormat.Shape.STRING)
    @JsonProperty(value = "date_finish")
    private LocalDateTime dateFinish;
}
