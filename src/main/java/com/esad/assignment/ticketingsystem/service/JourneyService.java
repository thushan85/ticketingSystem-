package com.esad.assignment.ticketingsystem.service;

import com.esad.assignment.ticketingsystem.model.Journey;

import java.util.List;

public interface JourneyService {
    List<Journey> findByPassengerId(Integer passengerId);
}
