package com.esad.assignment.ticketingsystem.service.user;

import com.esad.assignment.ticketingsystem.exception.DataNotFoundException;
import com.esad.assignment.ticketingsystem.model.User;
import com.esad.assignment.ticketingsystem.request.TopupRequest;
import com.esad.assignment.ticketingsystem.request.UserLoginRequest;
import com.esad.assignment.ticketingsystem.request.UserRegisterRequest;

import java.util.HashMap;
import java.util.Optional;

public interface UserRegistrationService {
    User register(UserRegisterRequest request);
    HashMap<String, Object> login(UserLoginRequest request) throws DataNotFoundException;
    User getUserDetails(Integer userId) throws  DataNotFoundException;
    User topup(TopupRequest topupRequest) throws DataNotFoundException;
}
