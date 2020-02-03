package com.api.hotelbooking.room;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND) //changes from 501 internal service error to 404 not found
public class RoomNotFoundException extends RuntimeException {
    public RoomNotFoundException(String message) {
        super(message); //displays id message not found
    }
}
