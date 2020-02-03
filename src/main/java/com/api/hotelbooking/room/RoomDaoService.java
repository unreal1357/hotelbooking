package com.api.hotelbooking.room;

import org.aspectj.apache.bcel.generic.RET;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
what is a DAO?
Data access object
A class that WE are are writing to access the database (ArrayList currently but will be db soon)
DAO class contains CRUD methods
might need to elaborate some more on this or ask morgan
 */

//created a few rooms in here and created some methods - to find all room, save a room(will delete when restart program) and to search a specific room.


//@Repository I think i need to add this when talking to the database
@Component //makes this class to be managed by spring
public class RoomDaoService {

    //    using this temporarily until database is implemented -- just adding simple rooms
    private static List<Room> rooms = new ArrayList<>(); //creating a list that uses Room constructor

    //    determine the room ID
    private static int userCount = 3;
//static methods can be called without creating an object of a class.
    static {
        //rooms.add(new Room(1, "Standard", "Two adults", 100));
    }

/*
methods to return a specific room and a method to return all the rooms
 */

    //    find all method
    public List<Room> findAll() {
        return rooms;
    }

    //save user to database (array list at the moment in this case)
    public Room save(Room room) {
//        checking if id is null, if not then setting the id and adding the user to the list
        if (room.getId() == null) { // saying if the room does not have an ID
            room.setId(++userCount);// set the id to increment to next id number
        }
            rooms.add(room);
            return room;
        }

//        get specific room
    public Room findOne(int id) {
//        for room id is equal to a room in the array list created above, return it, if not return null???
     for(Room room:rooms) { // *****need to understand how ':' works properly***** to do
         if(room.getId() ==id){
             return room;
         }
    }
     return null; //means it is not found
    }

//    this method deletes the resource and returning the resource back
    //returning 404 error - i want it to return 200 - to fix
    public Room deleteById(int id) {
        rooms.removeIf(room -> room.getId().equals(id));

        return null; //means it is not found
    }
}
