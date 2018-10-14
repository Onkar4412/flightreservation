package com.onkar.flightreservation.services;

import com.onkar.flightreservation.dto.ReservationRequest;
import com.onkar.flightreservation.entities.Reservation;

public interface ReservationService {
	
	public Reservation bookFlight(ReservationRequest request);

}
