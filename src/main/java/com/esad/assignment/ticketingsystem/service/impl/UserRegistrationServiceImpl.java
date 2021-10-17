package com.esad.assignment.ticketingsystem.service.impl;

import com.esad.assignment.ticketingsystem.exception.DataNotFoundException;
import com.esad.assignment.ticketingsystem.model.User;
import com.esad.assignment.ticketingsystem.model.Vehicle;
import com.esad.assignment.ticketingsystem.model.enums.UserType;
import com.esad.assignment.ticketingsystem.repository.UserRepository;
import com.esad.assignment.ticketingsystem.repository.VehicleRepository;
import com.esad.assignment.ticketingsystem.request.UserLoginRequest;
import com.esad.assignment.ticketingsystem.request.UserRegisterRequest;
import com.esad.assignment.ticketingsystem.service.user.UserRegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Slf4j
@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

    private final UserRepository userRepository;
    private  final VehicleRepository vehicleRepository;

    @Autowired
    public UserRegistrationServiceImpl(UserRepository userRepository, VehicleRepository vehicleRepository) {
        this.userRepository = userRepository;
        this.vehicleRepository = vehicleRepository;
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
        user.setCurrentBalance(0.00);

        user = this.userRepository.save(user);
        log.debug("Saved user instance: {}", user);
        log.info("User created successfully");

        return user;
    }

    @Override
    public HashMap <String, Object> login(UserLoginRequest request)  throws  DataNotFoundException {

        HashMap<String, Object> data = new HashMap<>();

        User user = this.userRepository.findUserByMobileNumberAndUserType(request.getMobileNumber(), request.getUserType())
                .orElseThrow(() -> new DataNotFoundException("User not found."));

        data.put("user", user);

        if (user.getUserType().equals(UserType.DRIVER)) {
            Vehicle vehicle = vehicleRepository.findVehicleByDriverId(user.getId()).orElse(new Vehicle());  //.orElseThrow(() -> new DataNotFoundException("Driver has not assigned to a vehicle yet."));
            data.put("vehicle", vehicle);
        }
        return  data;
    }

    @Override
    public User getUserDetails(Integer userId) throws DataNotFoundException{
       User user = this.userRepository.findById(userId).orElseThrow(() -> new DataNotFoundException("User not found"));
       return  user;
    }
}
