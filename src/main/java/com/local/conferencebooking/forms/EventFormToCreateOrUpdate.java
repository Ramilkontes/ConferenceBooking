package com.local.conferencebooking.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventFormToCreateOrUpdate {
    @Valid
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 13, message = "Name should be between 2 and 13 characters")
    private String name;

    @Valid
    @NotEmpty(message = "Date should not be empty")
    @FutureOrPresent(message = "Sorry, event in the past can't be create")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dateStart;

    /*@JsonFormat(pattern="yyyy-MM-dd HH:mm", shape = JsonFormat.Shape.STRING)
    @JsonProperty(value = "date_finish")*/
    @Valid
    @NotEmpty(message = "Date should not be empty")
    @FutureOrPresent(message = "Sorry, event in the past can't be create")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dateFinish;
}
