package com.hotel.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.backend.model.Room;

public interface RoomRepository extends JpaRepository<Room,Long> {

}
