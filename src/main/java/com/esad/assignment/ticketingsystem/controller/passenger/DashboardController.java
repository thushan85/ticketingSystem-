package com.esad.assignment.ticketingsystem.controller.passenger;

import com.esad.assignment.ticketingsystem.controller.BaseController;
import com.esad.assignment.ticketingsystem.model.Journey;
import com.esad.assignment.ticketingsystem.model.User;
import com.esad.assignment.ticketingsystem.request.TopupRequest;
import com.esad.assignment.ticketingsystem.response.ErrorResponse;
import com.esad.assignment.ticketingsystem.response.SuccessResponse;
import com.esad.assignment.ticketingsystem.service.JourneyService;
import com.esad.assignment.ticketingsystem.service.user.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api/v1/passenger/dashboard")
public class DashboardController extends BaseController {

    @Autowired
    UserRegistrationService userRegistrationService;

    @Autowired
    JourneyService journeyService;

    @GetMapping("/{userId}")
    public Object myDashboard(@PathVariable Integer userId) {

        Object response = null;

        try {
            HashMap<String, Object> data = new HashMap<>();
            User user = userRegistrationService.getUserDetails(userId);
            Journey journey = journeyService.getLastJourney(userId);

            data.put("user", user);
            data.put("lastJourney", journey);
            response = new SuccessResponse(data, "Success");
        } catch (RuntimeException e) {
            this.logger.warning(e.getMessage());
            response = new ErrorResponse(e.getMessage());
        }

        return ResponseEntity
            .ok()
            .body(response);
    }

    @PostMapping("/topup")
    public Object topup(@RequestBody TopupRequest topupRequest) {
        Object response = null;
        try {
            User user = userRegistrationService.topup(topupRequest);
            response = new SuccessResponse(user, "Success");
        } catch (RuntimeException e) {
            this.logger.warning(e.getMessage());
            response = new ErrorResponse(e.getMessage());
        }
        return ResponseEntity
            .ok()
            .body(response);
    }
}
