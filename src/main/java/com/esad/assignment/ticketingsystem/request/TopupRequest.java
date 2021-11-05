package com.esad.assignment.ticketingsystem.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TopupRequest {
    private int passengerId;
    private double amount;
}
