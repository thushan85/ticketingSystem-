package com.esad.assignment.ticketingsystem.service;

import com.esad.assignment.ticketingsystem.exception.JourneyException;
import com.esad.assignment.ticketingsystem.model.Journey;
import com.esad.assignment.ticketingsystem.request.JourneyRequest;

import java.util.List;
import java.util.Optional;

public interface JourneyService {
    List<Journey> findByPassengerId(Integer passengerId);
    Journey scanTicket(JourneyRequest journeyRequest) throws JourneyException;
    Journey getLastJourney(Integer passengerId);
}
