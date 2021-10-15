package com.esad.assignment.ticketingsystem.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserRegisterRequest {

    private String nic;

    private String email;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("mobile_number")
    private String mobileNumber;
}
