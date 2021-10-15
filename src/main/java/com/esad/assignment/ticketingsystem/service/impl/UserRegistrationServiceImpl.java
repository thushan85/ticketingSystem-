package com.esad.assignment.ticketingsystem.service.impl;

import com.esad.assignment.ticketingsystem.model.User;
import com.esad.assignment.ticketingsystem.model.enums.UserType;
import com.esad.assignment.ticketingsystem.repository.UserRepository;
import com.esad.assignment.ticketingsystem.request.UserRegisterRequest;
import com.esad.assignment.ticketingsystem.service.user.UserRegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

    private final UserRepository userRepository;

    @Autowired
    public UserRegistrationServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(UserRegisterRequest request) {

        if (this.userRepository.existsByEmail(request.getEmail()) || this.userRepository.existsByNic(request.getNic())) {
            throw new RuntimeException("User exist system. Please login");
        }

        User user = new User();
        user.setNic(request.getNic());
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setMobileNumber(request.getMobileNumber());
        user.setUserType(UserType.PASSENGER);

        user = this.userRepository.save(user);
        log.debug("Saved user instance: {}", user);
        log.info("User created successfully");

        return user;
    }
}
