package com.esad.assignment.ticketingsystem.repository;

import com.esad.assignment.ticketingsystem.model.Journey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JourneyRepository extends JpaRepository<Journey, Integer> {
    List<Journey> findJourneyByPassengerId(Integer passengerId);
    Optional<Journey> findJourneyByPassengerIdOrderByEndTimeDesc(Integer passengerId);
    Optional<Journey> findJourneyByPassengerIdAndIsCurrent(Integer passengerId, Integer isCurrent);
}

