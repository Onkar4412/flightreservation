package com.onkar.flightreservation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onkar.flightreservation.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
