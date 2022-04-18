package com.local.conferencebooking.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserForm {
    private String firstName;
    private String lastName;
    private String login;
    private String password;
}
