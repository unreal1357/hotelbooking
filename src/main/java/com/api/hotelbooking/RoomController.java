package com.api.hotelbooking;

import com.api.hotelbooking.Room;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController //what does this mean
public class RoomController {

    @GetMapping("/rooms") //what does get mapping mean
        public List<Room> getAllRooms(){
            return Arrays.asList(new Room(1,100,"standard","2 adults"));

    }
}
