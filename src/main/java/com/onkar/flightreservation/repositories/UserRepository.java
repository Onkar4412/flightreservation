package com.onkar.flightreservation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onkar.flightreservation.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

}
