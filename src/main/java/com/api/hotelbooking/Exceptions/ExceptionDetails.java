package com.api.hotelbooking.Exceptions;

import java.util.Date;

//exception response bean -- generic exception handling
public class ExceptionDetails {

    private Date timestamp;
    private String message;
    private String details;
//    add status?

    public ExceptionDetails(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
