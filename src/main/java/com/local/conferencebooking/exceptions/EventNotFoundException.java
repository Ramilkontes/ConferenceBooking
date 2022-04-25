package com.local.conferencebooking.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class EventNotFoundException extends RuntimeException{
    public EventNotFoundException(String msg) {
        super(msg);
    }
}
