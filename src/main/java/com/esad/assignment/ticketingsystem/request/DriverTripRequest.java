package com.esad.assignment.ticketingsystem.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DriverTripRequest {
    private Integer tripId; //this will be null when start a trip
    private Integer vehicleId;
}
