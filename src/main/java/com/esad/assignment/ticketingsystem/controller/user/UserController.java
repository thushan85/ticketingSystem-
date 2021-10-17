package com.esad.assignment.ticketingsystem.controller.user;

import com.esad.assignment.ticketingsystem.controller.BaseController;
import com.esad.assignment.ticketingsystem.model.User;
import com.esad.assignment.ticketingsystem.request.UserLoginRequest;
import com.esad.assignment.ticketingsystem.request.UserRegisterRequest;
import com.esad.assignment.ticketingsystem.response.ErrorResponse;
import com.esad.assignment.ticketingsystem.response.SuccessResponse;
import com.esad.assignment.ticketingsystem.service.user.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(path = "/api/v1/user")
public class UserController extends BaseController {
    private final UserRegistrationService userRegistrationService;

    @Autowired
    public UserController(UserRegistrationService userRegistrationService) {
        this.userRegistrationService = userRegistrationService;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/register", produces = "application/json")
    public ResponseEntity<SuccessResponse> registerUser(@RequestBody UserRegisterRequest request) {

        this.logger.info(request.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new SuccessResponse(this.userRegistrationService.register(request), "User created successfully"));
    }

    @PostMapping(path = "/login")
    public Object login(@RequestBody UserLoginRequest request) {
        Object response = null;

        try {
            HashMap<String, Object> userData = this.userRegistrationService.login(request);
            response = new SuccessResponse(userData, "Login success");
        } catch (RuntimeException e) {
            response = new ErrorResponse(e.getMessage());
            this.logger.warning(e.getMessage());
        }
        return ResponseEntity
            .ok()
            .body(response);

    }
}
