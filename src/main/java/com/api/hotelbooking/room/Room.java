package com.api.hotelbooking.room;

//this is a simple bean

import javax.validation.constraints.Size;

//nothing in here is validated at the moment
//using java validation api to add validations on beans
//when get a request to create a user, want to validate the content and if its invalid, want to return a proper response back
public class Room {

    private Integer id; //using as primary key

    @Size(min = 3, message = "Name should have at least 3 characters")//comes from javax.validation API - meaning name has to be at least 3 characters using Java API and validation
    private String name;

    private String size;
    //could add @Min/@Max here maybe? not sure if much point unless want to add limitations
    private int price;

    public Room(Integer id, String name, String size, int price) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                '}';
    }

}