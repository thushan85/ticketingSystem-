package com.esad.assignment.ticketingsystem.repository;

import com.esad.assignment.ticketingsystem.model.Journey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JourneyRepository extends JpaRepository<Journey, Integer> {
    List<Journey> findJourneyByPassengerId(Integer passengerId);
}

