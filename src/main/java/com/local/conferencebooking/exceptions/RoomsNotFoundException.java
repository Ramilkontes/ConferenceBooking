package com.local.conferencebooking.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RoomsNotFoundException extends RuntimeException{
    public RoomsNotFoundException(String msg) {
        super(msg);
    }
}
