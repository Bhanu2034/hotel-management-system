package com.hotel.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.backend.model.Booking;
import com.hotel.backend.service.BookingService;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "http://localhost:5173")
public class BookingController {
	
	private final BookingService bookingService;
	
	public BookingController(BookingService bookingService) {
		this.bookingService = bookingService;
	}
	
	@GetMapping
	public List<Booking> getBookings(){
		return bookingService.getAllBookings();
	}
	
	@PostMapping("/{roomId}")
	public Booking createBooking(@PathVariable Long roomId, @RequestBody Booking booking) {
		return bookingService.createBooking(roomId, booking);
	}
}
