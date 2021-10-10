package com.esad.assignment.ticketingsystem.controller.passenger;

import com.esad.assignment.ticketingsystem.controller.BaseController;
import com.esad.assignment.ticketingsystem.model.Journey;
import com.esad.assignment.ticketingsystem.response.SuccessResponse;
import com.esad.assignment.ticketingsystem.service.JourneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/passenger/journey")
public class JourneyController extends BaseController {

    @Autowired
    JourneyService journeyService;

    @PostMapping("/start")
    public Object checkIn() {
        return  null;
    }

    @PostMapping("/end")
    public Object checkout() {
        return  null;
    }

    @GetMapping("/list")
    public Object journeyHistory() {

        List<Journey> journeyList = journeyService.findByPassengerId(1);
        logger.info("call journey/list");
        return ResponseEntity
                .ok()
                .body(new SuccessResponse(journeyList));
    }
}

