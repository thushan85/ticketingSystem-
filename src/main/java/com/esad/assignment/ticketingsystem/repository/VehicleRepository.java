package com.esad.assignment.ticketingsystem.repository;

import com.esad.assignment.ticketingsystem.model.User;
import com.esad.assignment.ticketingsystem.model.Vehicle;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface VehicleRepository  extends JpaRepository<Vehicle, Integer> {
    Optional<Vehicle> findVehicleByDriverId(Integer driverId);
}