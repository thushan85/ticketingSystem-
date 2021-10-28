package com.esad.assignment.ticketingsystem.lib.feecalulator.rate;

public class RateFactory {

    public static String RATE_TRAIN = "train";
    public static String RATE_BUS   = "bus";

    public static Rate getRate(String type) {
        if (type == RATE_BUS) {
            return new BusRate();
        } else if(type.equals(RATE_TRAIN)) {
            return new TrainRate();
        } else {
            return new NoRate();
        }
    }
}
