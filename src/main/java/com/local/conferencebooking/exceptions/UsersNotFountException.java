package com.local.conferencebooking.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UsersNotFountException extends RuntimeException {
    public UsersNotFountException(String msg) {
        super(msg);
    }
}
