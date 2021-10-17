package com.esad.assignment.ticketingsystem.service;

import com.esad.assignment.ticketingsystem.exception.TripException;
import com.esad.assignment.ticketingsystem.model.Trip;
import com.esad.assignment.ticketingsystem.request.DriverTripRequest;

public interface TripService {
    Trip start(DriverTripRequest request) throws TripException;
    Trip end(DriverTripRequest request) throws TripException;
    Trip getCurrentTrip(Integer tripId) throws  TripException;
}
