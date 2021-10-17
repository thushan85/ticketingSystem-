package com.esad.assignment.ticketingsystem.model;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "vehicles")
@Getter
@Setter
@ToString
public class Vehicle extends Serializers.Base {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name = "native", strategy = "native")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User ownerId;

    private String regNo;

    @ManyToOne
    @JoinColumn(name = "route_id", nullable = false)
    private Route routeId;

    @ManyToOne
    @JoinColumn(name = "driver_id", nullable = false)
    private User driverId;
}
