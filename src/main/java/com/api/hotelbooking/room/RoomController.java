package com.api.hotelbooking.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;

/*
question - does saying @RestController make this a bean?
 */

@RestController //makes class handle REST requests && includes @Controller and @ResponseBody
public class RoomController {

    /**auto wiring**
     All spring beans managed in application context

     Auto wiring happens by placing an instance of one bean into the desired field in an instance of another bean.
     Both classes should be beans, i.e. they should be defined to live in the application context.

     how i think @Autowired works - placing an instance in here of RoomDaoService into this bean.

     */

//    telling application context to inject an instance of RoomDaoService here
    @Autowired
    private RoomDaoService service; //creating "service" variable of type RoomDaoService class

//    retrieveAllRooms Method
    @GetMapping("/rooms")
    public List<Room> retrieveAllRooms(){
        return service.findAll(); // Question - Can use because instance of RoomDaoService has been injected from auto wiring?
    }

//    GET specific room Method
    @GetMapping("/rooms/{id}")
    public Room retrieveRoom(@PathVariable int id){ //using @pathVariable means it will get the id from what is entered in the URL
        return service.findOne(id); //returns id that is in path URL
    }
}
