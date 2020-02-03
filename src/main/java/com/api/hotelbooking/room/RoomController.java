package com.api.hotelbooking.room;

import com.api.hotelbooking.Exceptions.RoomNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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
        Room room = service.findOne(id); //returns id that is in path URL
//        adding exception when searching invalid room id, gives 500 status code and can add an error message using UserNotFoundException class
        if(room==null)
            throw new RoomNotFoundException("id-" + id);
        return room;
    }


    @DeleteMapping("/rooms/{id}")
    public void DeleteRoom(@PathVariable int id){ //using @pathVariable means it will get the id from what is entered in the URL
        Room room = service.deleteById(id); //calling deleteById method from DaoService
        if(room==null)
            throw new RoomNotFoundException("id-" + id); //if user is null return exception
//        if user is deleted no response is given and has a status code of 200 -- maybe I could add a message saying its been deleted

    }

/*
using postman to test POST requests
Method returns status code 201 --> resource is created
in the headers of post request it shows location which has location of resource of the newly created room
e.g http://localhost8081:8081/rooms/4
 */

    @PostMapping("/rooms") //using post because... using POST request
    //@RequestBody, whatever i parse into POST body of request will be mapped to "room" parameter here
    //when get a request to create a room want to validate content, enabling validation on this specific room
//    using @Valid - Java Validation API
    public ResponseEntity<Object> createRoom(@Valid @RequestBody Room room) { //adding validations from Room bean
        Room savedRoom = service.save(room);

        //returning output from post request to show it was successful
//      creating a status code in response body and showing new ID of room in body

//        creating URL for 'location'
        //next two lines this return current request URL it gets --> /user
        URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()

        .path("/{id}") //appending /id onto the end of /rooms to make show - /rooms/{created id}
        .buildAndExpand(savedRoom.getId()).toUri(); //replacing /room/{id} with 'savedRoom.getID' which gets id from save method (creates new)

//        Response entity is part of spring framework, extension of httpEntity but adds a status code to return back also
//        created allows to parse in the location of the resource which was created
        return ResponseEntity.created(location).build(); //used to return a created status
    }
}
