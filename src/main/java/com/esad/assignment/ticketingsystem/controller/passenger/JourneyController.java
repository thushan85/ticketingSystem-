package com.esad.assignment.ticketingsystem.controller.passenger;

import com.esad.assignment.ticketingsystem.controller.BaseController;
import com.esad.assignment.ticketingsystem.model.Journey;
import com.esad.assignment.ticketingsystem.request.JourneyRequest;
import com.esad.assignment.ticketingsystem.response.ErrorResponse;
import com.esad.assignment.ticketingsystem.response.SuccessResponse;
import com.esad.assignment.ticketingsystem.service.JourneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/passenger/journey")
public class JourneyController extends BaseController {

    @Autowired
    JourneyService journeyService;

    @GetMapping("/list/{passengerId}")
    public Object journeyHistory(@PathVariable Integer passengerId) {

        List<Journey> journeyList = journeyService.findByPassengerId(passengerId);
        logger.info("call journey/list");
        return ResponseEntity
                .ok()
                .body(new SuccessResponse(journeyList));
    }
}

