package com.hotel.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hotel.backend.model.Room;
import com.hotel.backend.repository.RoomRepository;

@Service
//It says that class as a Service layer 
//Tells Spring to detect it automatically and create an object (bean)
public class RoomService {
	private final RoomRepository roomRepository;
	
	public RoomService(RoomRepository roomRepository) {
		this.roomRepository = roomRepository;
	}
	
	public List<Room> getAllRooms(){
		return roomRepository.findAll();
	}
	
	public Room addRoom(Room room) {
		return roomRepository.save(room);
	}
}
