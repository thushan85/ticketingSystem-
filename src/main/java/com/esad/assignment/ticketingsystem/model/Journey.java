package com.esad.assignment.ticketingsystem.model;

import com.esad.assignment.ticketingsystem.model.enums.JourneyEventType;
import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@ToString
@Entity
@Table(name = "journeys")
public class Journey extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name = "native", strategy = "native")
    private Integer id;
    private Integer passengerId;

    private Timestamp startTime;
    private Timestamp endTime;

    @Column(name = "trip_id")
    private Integer tripId;

    private Integer isCurrent;

    @Column(name = "start_location_id")
    private Integer startLocationId;

    @Column(name = "end_location_id")
    private Integer endLocationId;

    @ManyToOne
    @JoinColumn(name = "start_location_id", nullable = false, insertable = false, updatable = false)
    private Location startLocation;

    @ManyToOne
    @JoinColumn(name = "end_location_id", nullable = false, insertable = false, updatable = false)
    private Location endLocation;

    @Column(columnDefinition = "decimal(10,2)")
    private Double journeyFare;

    @ManyToOne
    @JoinColumn(name = "trip_id", nullable = false, insertable = false, updatable = false)
    private Trip trip;

    @Enumerated(EnumType.STRING)
    @Transient
    private JourneyEventType eventType;

}
