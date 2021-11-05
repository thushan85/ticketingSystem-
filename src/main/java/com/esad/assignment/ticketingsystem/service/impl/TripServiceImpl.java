package com.esad.assignment.ticketingsystem.service.impl;

import com.esad.assignment.ticketingsystem.config.Constants;
import com.esad.assignment.ticketingsystem.exception.TripException;
import com.esad.assignment.ticketingsystem.model.Trip;
import com.esad.assignment.ticketingsystem.repository.TripRepository;
import com.esad.assignment.ticketingsystem.repository.VehicleRepository;
import com.esad.assignment.ticketingsystem.request.DriverTripRequest;
import com.esad.assignment.ticketingsystem.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TripServiceImpl implements TripService {

    private final TripRepository tripRepository;
    private final VehicleRepository vehicleRepository;

    @Autowired
    public TripServiceImpl(TripRepository tripRepository, VehicleRepository vehicleRepository) {
        this.tripRepository = tripRepository;
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Trip start(DriverTripRequest request) throws TripException {
        Trip trip = new Trip();
        trip.setVehicleId(request.getVehicleId());
        trip.setCurrentLocation(2);
        trip.setVehicle(this.vehicleRepository.getById(request.getVehicleId()));
        trip.setIsCurrentTrip(Constants.CURRENT_TRIP);
        trip = tripRepository.save(trip);
        return trip;
    }

    @Override
    public Trip end(DriverTripRequest request) throws TripException {
        Trip trip = tripRepository.findById(request.getTripId()).orElseThrow(() -> new TripException("A trip not found with the tripId:" + request.getTripId()));
        trip.setIsCurrentTrip(Constants.NOT_CURRENT_TRIP);
        tripRepository.save(trip);
        return trip;
    }

    @Override
    public Trip getCurrentTrip(Integer tripId) throws TripException {
        return tripRepository.findById(tripId).orElseThrow(() -> new TripException("A trip not found with the tripId:" + tripId));
    }
}
