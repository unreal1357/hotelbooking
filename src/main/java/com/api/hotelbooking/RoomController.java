package com.api.hotelbooking;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class RoomController {

    @GetMapping("/rooms")
        public List<Room> getAllRooms(){
            return Arrays.asList(new Room(1,100,"standard","2 adults"));

    }
}
