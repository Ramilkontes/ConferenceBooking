package com.local.conferencebooking.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventFormToFindByName {
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 13, message = "Name should be between 2 and 13 characters")
    String name;
}
