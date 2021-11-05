package com.esad.assignment.ticketingsystem.service.impl;

import com.esad.assignment.ticketingsystem.config.Constants;
import com.esad.assignment.ticketingsystem.exception.JourneyException;
import com.esad.assignment.ticketingsystem.exception.RateExeception;
import com.esad.assignment.ticketingsystem.lib.feecalulator.Distance;
import com.esad.assignment.ticketingsystem.lib.feecalulator.PriceStrategy;
import com.esad.assignment.ticketingsystem.lib.feecalulator.rate.Rate;
import com.esad.assignment.ticketingsystem.lib.feecalulator.rate.RateFactory;
import com.esad.assignment.ticketingsystem.model.Journey;
import com.esad.assignment.ticketingsystem.model.Location;
import com.esad.assignment.ticketingsystem.model.enums.JourneyEventType;
import com.esad.assignment.ticketingsystem.repository.JourneyRepository;
import com.esad.assignment.ticketingsystem.repository.LocationRepository;
import com.esad.assignment.ticketingsystem.request.JourneyRequest;
import com.esad.assignment.ticketingsystem.service.JourneyService;
import com.esad.assignment.ticketingsystem.utils.DateTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class JourneyServiceImpl implements JourneyService {

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
        Journey journey = journeyRepository.findJourneyByPassengerIdAndIsCurrent(journeyRequest.getPassengerId(), Constants.IS_CURRENT_JOURNEY)
                .orElse(new Journey());

        if (journey.getId() != null && journey.getId() > 0) {
            journey = this.end(journeyRequest, journey);
        } else {
            journey = this.start(journeyRequest);
            log.warn(journey.toString());
            log.warn(journeyRequest.toString());
        }
        return journey;
    }

    @Override
    public Journey getLastJourney(Integer passengerId) {
        return journeyRepository.findJourneyByPassengerIdOrderByEndTimeDesc(passengerId).orElse(null);
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

        double fare = getFare(journey.getStartLocation(), location, "bus");

        journey.setEndLocationId(location.getId());
        journey.setEndTime(DateTime.getCurrentTimeStamp());
        journey.setIsCurrent(Constants.PAST_JOURNEY);
        journey.setJourneyFare(fare);
        journey.setEventType(JourneyEventType.CHECKOUT);
        return journeyRepository.save(journey);
    }

    private double getFare(Location start, Location end, String vehicleType) {
        Rate rate = null;
        double fare = 0.0;
        try {
            if (vehicleType.equals(RateFactory.RATE_BUS)) {
                rate = RateFactory.getRate(RateFactory.RATE_BUS);
            } else if (vehicleType.equals(RateFactory.RATE_TRAIN)) {
                rate = RateFactory.getRate(RateFactory.RATE_TRAIN);
            } else {
                throw new RateExeception("Invalid vehicleType " + vehicleType);
            }

            PriceStrategy priceStrategy = new PriceStrategy();
            priceStrategy.setRate(rate);

            Distance distance = new Distance(
                    new com.esad.assignment.ticketingsystem.lib.feecalulator.Location(Double.parseDouble(start.getLat()), Double.parseDouble(start.getLng())),
                    new com.esad.assignment.ticketingsystem.lib.feecalulator.Location(Double.parseDouble(end.getLat()), Double.parseDouble(end.getLng()))
            );

            priceStrategy.setDistance(distance);
            fare = priceStrategy.getTicketPrice();

            log.info("distance: {} KM", String.format("%.3f", priceStrategy.getKm()));
            log.info("bus ticket: LKR. {}", String.format("%.2f", fare));

        } catch (Exception e) {
            log.error("An error occurred in getFare. error " + e.getMessage());
        }

        return fare;
    }
}
