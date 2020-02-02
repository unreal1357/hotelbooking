package com.api.hotelbooking;

public class Room {
    long id;
    int price;
    String Name;
    String size;

    public Room(long id, int price, String name, String size) {
        this.id = id;
        this.price = price;
        Name = name;
        this.size = size;
    }

    public long getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return Name;
    }

    public String getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", price=" + price +
                ", Name='" + Name + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
