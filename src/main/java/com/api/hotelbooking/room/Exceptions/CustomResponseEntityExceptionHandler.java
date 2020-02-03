package com.api.hotelbooking.room.Exceptions;

import com.api.hotelbooking.room.RoomNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

/*
ResponseEntityExceptionHandler is a class present in spring (abstract class) that can be extended to provide centralised exception handling
across all different exception handlers, can use this on as the base class to provide default exception handling for all requests
extend it
 */

@ControllerAdvice //implements this to work across all RestController classes/Beans
@RestController //because providing a response back when there are exceptions
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class) //means to handle all exceptions using .class
    //the code below is required to override for specific exceptions
    public final ResponseEntity<Object> handleAllExceptions
            (Exception ex, WebRequest request) throws Exception {

//        creating object of ExceptionDetails from my constructor in ExceptionDetails bean to return in body (only when exception occurs)
        ExceptionDetails exceptionDetails = new ExceptionDetails
                (new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity(exceptionDetails, HttpStatus.INTERNAL_SERVER_ERROR); //returns constructor and status code error in body
    }


//    custom exception for room not found which returns 404 error and not 501 Internal server error
    @ExceptionHandler(RoomNotFoundException.class) //using for specific bean
    public final ResponseEntity<Object> handleRoomNotFoundExceptions
            (Exception ex, WebRequest request) throws Exception {

        ExceptionDetails exceptionDetails = new ExceptionDetails
                (new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity(exceptionDetails, HttpStatus.NOT_FOUND);
    }

    //add one for booking too
}
