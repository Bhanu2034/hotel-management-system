package com.hotel.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

//the table of room is 
	//id,roomNo,type,pricePerNight,available 


@Entity // It says class represent JPA entity
@Data
public class Room {
	
	@Id  //It gives You primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//It says the database to how to generate primary key
	private Long id;
	
	private String roomNo;
	private String type;
	private double pricePerNight;
	private boolean available;
	
}
