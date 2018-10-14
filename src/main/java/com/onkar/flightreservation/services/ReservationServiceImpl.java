package com.onkar.flightreservation.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onkar.flightreservation.dto.ReservationRequest;
import com.onkar.flightreservation.entities.Flight;
import com.onkar.flightreservation.entities.Passenger;
import com.onkar.flightreservation.entities.Reservation;
import com.onkar.flightreservation.repositories.FlightRepository;
import com.onkar.flightreservation.repositories.PassengerRepository;
import com.onkar.flightreservation.repositories.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private FlightRepository flightRepository;
	
	@Autowired
	private PassengerRepository passengerRepository;
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Override
	public Reservation bookFlight(ReservationRequest request) {
		//First step is to make payment by connecting to payment gateway interface by getting all card details.
		//request.getCardNumber();
		
		long flightId = request.getFlightId();
		Flight flight = flightRepository.getOne(flightId);
		
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setEmail(request.getPassengerEmail());
		passenger.setPhone(request.getPassengerPhone());
		
		Passenger savedPassenger = passengerRepository.save(passenger);
		
		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);
		
		Reservation savedReservation = reservationRepository.save(reservation);
		
		return savedReservation;
	}

}
