package com.local.conferencebooking.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UsersNotFoundException extends RuntimeException {
    public UsersNotFoundException(String msg) {
        super(msg);
    }
}
