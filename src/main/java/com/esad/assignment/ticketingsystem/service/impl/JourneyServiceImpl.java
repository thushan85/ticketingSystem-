package com.esad.assignment.ticketingsystem.service.impl;

import com.esad.assignment.ticketingsystem.exception.DataNotFoundException;
import com.esad.assignment.ticketingsystem.model.Journey;
import com.esad.assignment.ticketingsystem.repository.JourneyRepository;
import com.esad.assignment.ticketingsystem.service.JourneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class JourneyServiceImpl implements JourneyService {

    @Autowired
    JourneyRepository journeyRepository;

    @Override
    public List<Journey> findByPassengerId(Integer passengerId) {
        return journeyRepository.findJourneyByPassengerId(passengerId);
        //.orElseThrow(()-> new DataNotFoundException(String.format("journey list not found. PassengerID:%d", passengerId)) );
    }


}
