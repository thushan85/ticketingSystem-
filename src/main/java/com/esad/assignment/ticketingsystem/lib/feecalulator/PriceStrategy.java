package com.esad.assignment.ticketingsystem.lib.feecalulator;

import com.esad.assignment.ticketingsystem.lib.feecalulator.rate.Rate;

public class PriceStrategy {
    private Rate rate;
    private Distance distance;

    public void setRate(Rate rate) {
        this.rate = rate;
    }

    public Double getKm() {
        return distance.getDistance();
    }

    public void setDistance(Distance distance) {
        this.distance = distance;
    }

    public double getTicketPrice() {
        return rate.getRate() * distance.getDistance();
    }
}
