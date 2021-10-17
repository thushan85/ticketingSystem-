package com.esad.assignment.ticketingsystem.request;

import com.esad.assignment.ticketingsystem.model.enums.UserType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserLoginRequest {
    private UserType userType;
    private String mobileNumber;
}
