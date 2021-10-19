package com.esad.assignment.ticketingsystem.service.impl;

import com.esad.assignment.ticketingsystem.config.Constants;
import com.esad.assignment.ticketingsystem.exception.DataNotFoundException;
import com.esad.assignment.ticketingsystem.exception.JourneyException;
import com.esad.assignment.ticketingsystem.model.Journey;
import com.esad.assignment.ticketingsystem.model.Location;
import com.esad.assignment.ticketingsystem.model.enums.JourneyEventType;
import com.esad.assignment.ticketingsystem.repository.JourneyRepository;
import com.esad.assignment.ticketingsystem.repository.LocationRepository;
import com.esad.assignment.ticketingsystem.request.JourneyRequest;
import com.esad.assignment.ticketingsystem.service.JourneyService;
import com.esad.assignment.ticketingsystem.utils.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;


@Service
public class JourneyServiceImpl implements JourneyService {

    protected final Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    JourneyRepository journeyRepository;
    @Autowired
    LocationRepository locationRepository;

    @Override
    public List<Journey> findByPassengerId(Integer passengerId) {
        return journeyRepository.findJourneyByPassengerId(passengerId);
    }

    @Override
    public Journey scanTicket(JourneyRequest journeyRequest) throws JourneyException {
        Journey journey = journeyRepository.findJourneyByPassengerIdAndIsCurrent(journeyRequest.getPassengerId(), Constants.IS_CURRENT_JOURNEY).orElse(new Journey());

        if (journey.getId()  != null && journey.getId() > 0 ) {
            journey = this.end(journeyRequest, journey);
        } else {
            journey = this.start(journeyRequest);
            logger.warning(journey.toString());
            logger.warning(journeyRequest.toString());
        }
        return journey;
    }

    @Override
    public Journey getLastJourney(Integer passengerId) {
        return  journeyRepository.findJourneyByPassengerIdOrderByEndTimeDesc(passengerId).orElse(null);
    }

    private Journey start(JourneyRequest journeyRequest) throws JourneyException {
        Journey journey = new Journey();

        Location location = new Location();
        location.setLat(journeyRequest.getLat());
        location.setLng(journeyRequest.getLng());
        location = locationRepository.save(location);

        journey.setPassengerId(journeyRequest.getPassengerId());
        journey.setStartLocationId(location.getId());
        journey.setStartTime(DateTime.getCurrentTimeStamp());
        journey.setTripId(journeyRequest.getTripId());
        journey.setIsCurrent(Constants.IS_CURRENT_JOURNEY);
        journey.setEventType(JourneyEventType.CHECKIN);
        journey.setJourneyFare(0.00);
        return journeyRepository.save(journey);
    }

    private Journey end(JourneyRequest journeyRequest, Journey journey) throws JourneyException {
        Location location = new Location();
        location.setLat(journeyRequest.getLat());
        location.setLng(journeyRequest.getLng());
        location = locationRepository.save(location);

        journey.setEndLocationId(location.getId());
        journey.setEndTime(DateTime.getCurrentTimeStamp());
        journey.setIsCurrent(Constants.PAST_JOURNEY);
        journey.setJourneyFare(0.00);
        journey.setEventType(JourneyEventType.CHECKOUT);
        return journeyRepository.save(journey);
    }
}
