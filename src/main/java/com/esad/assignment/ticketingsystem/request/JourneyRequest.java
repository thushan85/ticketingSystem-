package com.esad.assignment.ticketingsystem.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JourneyRequest {
    private Integer passengerId;
    private Integer tripId;
    private String lat;
    private String lng;
}