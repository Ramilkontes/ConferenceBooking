package com.local.conferencebooking.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventFormToCreateOrUpdate {

    @NotBlank(message = "Name should not be empty or null")
    @Size(min = 2, max = 13, message = "Name should be between 2 and 13 characters")
    private String name;

    @NotNull(message = "Date should not be null")
    @FutureOrPresent(message = "Sorry, event in the past can't be create")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dateStart;

    @NotNull(message = "Date should not be null")
    @FutureOrPresent(message = "Sorry, event in the past can't be create")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dateFinish;
}