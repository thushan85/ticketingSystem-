package com.esad.assignment.ticketingsystem.service.user;

import com.esad.assignment.ticketingsystem.model.User;
import com.esad.assignment.ticketingsystem.request.UserRegisterRequest;

public interface UserRegistrationService {
    User register(UserRegisterRequest request);
}
