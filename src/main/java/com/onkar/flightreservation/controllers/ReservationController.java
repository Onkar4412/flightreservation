package com.onkar.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.onkar.flightreservation.dto.ReservationRequest;
import com.onkar.flightreservation.entities.Flight;
import com.onkar.flightreservation.entities.Reservation;
import com.onkar.flightreservation.repositories.FlightRepository;
import com.onkar.flightreservation.services.ReservationService;

@Controller
public class ReservationController {
	
	@Autowired
	private FlightRepository flightRepository;
	
	@Autowired
	private ReservationService reservationService;
	
	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") long flightId, ModelMap modelMap) {
		Flight flight = flightRepository.getOne(flightId);
		modelMap.addAttribute("flight", flight);
		return "completeReservation";
	}
	
	@RequestMapping(value="/completeReservation",method=RequestMethod.POST)
	public String completeReservation(ReservationRequest request, ModelMap modelMap) {
		Reservation reservation = reservationService.bookFlight(request);
		String reservationMessage= "Reservation created successfully and your reservation id is: "+reservation.getId();
		modelMap.addAttribute("reservationMessage", reservationMessage);
		return "reservationConfirmation";
	}
}
