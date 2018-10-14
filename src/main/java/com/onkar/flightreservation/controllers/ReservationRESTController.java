package com.onkar.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onkar.flightreservation.dto.ReservationUpdateRequest;
import com.onkar.flightreservation.entities.Reservation;
import com.onkar.flightreservation.repositories.ReservationRepository;

@RestController
public class ReservationRESTController {
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	@RequestMapping("/reservations/{id}")
	public Reservation findReservation(@PathVariable("id")long id) {
		return reservationRepository.getOne(id);
	}
	
	@RequestMapping("/reservations")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
		Reservation reservation = reservationRepository.getOne(request.getId());
		reservation.setNumberOfBags(request.getNumberOfBags());
		reservation.setCheckedIn(request.getCheckedIn());
		System.out.println("requestCheckIn: "+request.getCheckedIn());
		System.out.println("setCheckedIn: "+reservation.getCheckedIn());
		return reservationRepository.save(reservation);
		
	}

}
