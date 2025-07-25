package com.hotel.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.backend.model.Booking;

public interface BookingRepository extends JpaRepository<Booking,Long> {

}
