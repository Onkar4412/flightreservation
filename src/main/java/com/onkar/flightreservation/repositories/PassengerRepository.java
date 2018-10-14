package com.onkar.flightreservation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onkar.flightreservation.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
