package com.esad.assignment.ticketingsystem.controller.driver;

import com.esad.assignment.ticketingsystem.controller.BaseController;
import com.esad.assignment.ticketingsystem.model.Journey;
import com.esad.assignment.ticketingsystem.model.Trip;
import com.esad.assignment.ticketingsystem.request.DriverTripRequest;
import com.esad.assignment.ticketingsystem.request.JourneyRequest;
import com.esad.assignment.ticketingsystem.response.ErrorResponse;
import com.esad.assignment.ticketingsystem.response.SuccessResponse;
import com.esad.assignment.ticketingsystem.service.JourneyService;
import com.esad.assignment.ticketingsystem.service.TripService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/driver")
public class DriverController extends BaseController {

    @Autowired
    TripService tripService;

    @Autowired
    JourneyService journeyService;

    @PostMapping("/trip/start")
    public Object endTrip(@RequestBody DriverTripRequest request) {

        this.logger.warning(request.toString());
        Object response = null;
        try {
            Trip trip = tripService.start(request);
            response = new SuccessResponse(trip, "Trip has been successfully started.");
        } catch (RuntimeException e) {
            response = new ErrorResponse(e.getMessage());
            this.logger.warning(e.getMessage());
        }
        return ResponseEntity
            .ok()
            .body(response);
    }

    @PostMapping("/trip/end")
    public Object startTrip(@RequestBody DriverTripRequest request) {
        Object response = null;
        try {
            Trip trip = tripService.end(request);
            response = new SuccessResponse(trip, "Trip has been successfully ended.");
        } catch (RuntimeException e) {
            response = new ErrorResponse(e.getMessage());
            this.logger.warning(e.getMessage());
        }
        return ResponseEntity
            .ok()
            .body(response);
    }

    @GetMapping("/{dirverId}")
    public Object getCurrentTrip(@PathVariable Integer driverId) {
        return  null;
    }


    @PostMapping("/scan-ticket")
    public Object scan(@RequestBody JourneyRequest journeyRequest) {
        Journey journey = new Journey();
        Object response = null;
        try {
            journey = journeyService.scanTicket(journeyRequest);
            response = new SuccessResponse(journey, "Successfully scanned");
        } catch (RuntimeException e) {
            logger.warning("error in checkIn" + e.getMessage());
            response = new ErrorResponse("An error occurred while scanning ticket.");
        }
        return ResponseEntity
            .ok()
            .body(response);
    }
}
