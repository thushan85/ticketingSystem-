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

    @Column(name = "driver_Id")
    private Integer driverId;

    @Column(name = "owner_id")
    private  Integer ownerId;

    @Column(name = "route_id")
    private  Integer routeId;

    private String regNo;

    @ManyToOne
    @JoinColumn(name = "route_id", nullable = false, updatable = false, insertable = false)
    private Route route;

}
