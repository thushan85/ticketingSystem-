package com.esad.assignment.ticketingsystem.controller.user;

import com.esad.assignment.ticketingsystem.request.UserRegisterRequest;
import com.esad.assignment.ticketingsystem.response.SuccessResponse;
import com.esad.assignment.ticketingsystem.service.user.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/registration")
public class UserRegistrationController {
    private final UserRegistrationService userRegistrationService;

    @Autowired
    public UserRegistrationController(UserRegistrationService userRegistrationService) {
        this.userRegistrationService = userRegistrationService;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/", produces = "application/json")
    public ResponseEntity<SuccessResponse> registerUser(@RequestBody UserRegisterRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new SuccessResponse(this.userRegistrationService.register(request), "User created successfully"));
    }
}
