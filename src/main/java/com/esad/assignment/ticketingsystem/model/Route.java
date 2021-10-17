package com.esad.assignment.ticketingsystem.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "routes")
@Getter
@Setter
@ToString
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name = "native", strategy = "native")
    private Integer id;

    private String routeName;
    private String routeNumber;

    @ManyToOne
    @JoinColumn(name = "start_location", nullable = false)
    private Location startLocation;

    @ManyToOne
    @JoinColumn(name = "end_location", nullable = false)
    private Location endLocation;
    private String startLocationName;
    private String endLocationName;
}
