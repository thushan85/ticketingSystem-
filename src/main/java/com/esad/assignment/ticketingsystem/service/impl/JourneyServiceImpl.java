package com.esad.assignment.ticketingsystem.service.impl;

import com.esad.assignment.ticketingsystem.config.Constants;
import com.esad.assignment.ticketingsystem.exception.DataNotFoundException;
import com.esad.assignment.ticketingsystem.model.Journey;
import com.esad.assignment.ticketingsystem.model.Location;
import com.esad.assignment.ticketingsystem.repository.JourneyRepository;
import com.esad.assignment.ticketingsystem.request.JourneyRequest;
import com.esad.assignment.ticketingsystem.service.JourneyService;
import com.esad.assignment.ticketingsystem.utils.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class JourneyServiceImpl implements JourneyService {

    @Autowired
    JourneyRepository journeyRepository;

    @Override
    public List<Journey> findByPassengerId(Integer passengerId) {
        return journeyRepository.findJourneyByPassengerId(passengerId);
        //.orElseThrow(()-> new DataNotFoundException(String.format("journey list not found. PassengerID:%d", passengerId)) );
    }

    @Override
    public Journey start(JourneyRequest journeyRequest) {
        Journey journey = new Journey();
        Location location = new Location();

        location.setLat(journeyRequest.getLat());
        location.setLng(journeyRequest.getLng());
        journey.setStartLocation(location);
        journey.setStartTime(DateTime.getCurrentTimeStamp());
        journey.setTripId(journeyRequest.getTripId());
        journey.setIsCurrent(Constants.IS_CURRENT_JOURNEY);
        return journeyRepository.save(journey);
    }
}
