package com.esad.assignment.ticketingsystem.lib.feecalulator.rate;

public class NoRate implements Rate {
    @Override
    public float getRate() {
        return 0;
    }
}