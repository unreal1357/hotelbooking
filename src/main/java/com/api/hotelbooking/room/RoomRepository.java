package com.api.hotelbooking.room;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //what does this mean??? repository is an interface
public interface RoomRepository extends JpaRepository<Room, Integer> {


}
