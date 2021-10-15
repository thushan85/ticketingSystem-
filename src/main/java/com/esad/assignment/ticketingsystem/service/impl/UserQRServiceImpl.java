package com.esad.assignment.ticketingsystem.service.impl;

import com.esad.assignment.ticketingsystem.repository.UserRepository;
import com.esad.assignment.ticketingsystem.service.user.UserQRService;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class UserQRServiceImpl implements UserQRService {

    private final UserRepository userRepository;

    @Override
    public String getQRString(Integer userId) {

        return null;
    }
}
