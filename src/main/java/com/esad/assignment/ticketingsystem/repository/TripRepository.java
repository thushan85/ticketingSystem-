package com.esad.assignment.ticketingsystem.repository;

import com.esad.assignment.ticketingsystem.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, Integer> {

}
