package com.esad.assignment.ticketingsystem.lib.feecalulator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Distance {
    private Location start;
    private Location end;

    double getDistance() {
        String unit = "K";
        if ((start.getLat() == end.getLat()) && (start.getLng() == end.getLng())) {
            return 0;
        } else {
            double theta = start.getLng() - end.getLng();
            double dist = Math.sin(Math.toRadians(start.getLat())) * Math.sin(Math.toRadians(end.getLat())) + Math.cos(Math.toRadians(start.getLat())) * Math.cos(Math.toRadians(end.getLat())) * Math.cos(Math.toRadians(theta));
            dist = Math.acos(dist);
            dist = Math.toDegrees(dist);
            dist = dist * 60 * 1.1515;

            if (unit.equals("K")) {
                dist = dist * 1.609344;
            } else if (unit.equals("N")) {
                dist = dist * 0.8684;
            }
            return (dist);
        }
    }
}