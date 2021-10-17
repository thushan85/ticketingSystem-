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


//    @PostMapping("/start")
//    public Object checkIn(@RequestBody JourneyRequest journeyRequest) {
//        Journey journey = new Journey();
//        try {
//            journey = journeyService.start(journeyRequest);
//        } catch (RuntimeException e) {
//            logger.warning("error in checkIn" + e.getMessage());
//        }
//        return ResponseEntity
//            .ok()
//            .body(new SuccessResponse(journey, "Successfully checkedIn"));
//    }
//
//    @PostMapping("/end")
//    public Object checkout(@RequestBody JourneyRequest journeyRequest) {
//        Journey journey = new Journey();
//        Object response = null;
//        try {
//            journey = journeyService.start(journeyRequest);
//        } catch (RuntimeException e) {
//            logger.warning("error in chedckout" + e.getMessage());
//            response = new ErrorResponse(e.getMessage());
//        }
//        response = new SuccessResponse(journey, "Successfully checkedOut");
//
//        return ResponseEntity
//                .ok()
//                .body(response);
//    }

    @GetMapping("/list")
    public Object journeyHistory() {

        List<Journey> journeyList = journeyService.findByPassengerId(1);
        logger.info("call journey/list");
        return ResponseEntity
                .ok()
                .body(new SuccessResponse(journeyList));
    }
}

