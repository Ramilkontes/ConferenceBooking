package com.local.conferencebooking.forms;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventFormToCreateOrUpdate {
    private String name;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm", shape = JsonFormat.Shape.STRING)
    @JsonProperty(value = "date_start")
    private LocalDateTime dateStart;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm", shape = JsonFormat.Shape.STRING)
    @JsonProperty(value = "date_finish")
    private LocalDateTime dateFinish;
}
