package com.hotel.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hotel.backend.model.Booking;
import com.hotel.backend.model.Room;
import com.hotel.backend.repository.BookingRepository;
import com.hotel.backend.repository.RoomRepository;

@Service
public class BookingService {
	
	private final BookingRepository bookingRepository;
	private final RoomRepository roomRepository;
	
	public BookingService(BookingRepository bookingRepository,RoomRepository roomRepository) {
		this.bookingRepository = bookingRepository;
		this.roomRepository = roomRepository;
	}
	
	public List<Booking> getAllBookings(){
		return bookingRepository.findAll();
	}
	
	public Booking createBooking(Long roomid, Booking booking) {
		Optional<Room> roomOptional = roomRepository.findById(roomid);
		if(roomOptional.isPresent()) {
			Room room = roomOptional.get();
			if(room.isAvailable()) {
				booking.setRoom(room);
				room.setAvailable(false);
				roomRepository.save(room);
				return bookingRepository.save(booking);
			}
		}
		return null;
	}

}
