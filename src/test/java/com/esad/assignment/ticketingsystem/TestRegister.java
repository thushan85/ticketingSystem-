package com.esad.assignment.ticketingsystem;

import com.esad.assignment.ticketingsystem.model.enums.UserType;
import com.esad.assignment.ticketingsystem.request.UserLoginRequest;
import com.esad.assignment.ticketingsystem.request.UserRegisterRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestRegister {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    HttpHeaders headers = new HttpHeaders();

    @Test
    public void contextLoads() throws RuntimeException {
        UserRegisterRequest registerRequest = new UserRegisterRequest();
        registerRequest.setEmail("user@gmail.com");
        registerRequest.setFirstName("Test");
        registerRequest.setLastName("Passenger");
        registerRequest.setMobileNumber("0717358713");
        registerRequest.setNic("1234567890");

        HttpEntity<UserRegisterRequest> entity = new HttpEntity<UserRegisterRequest>(registerRequest, headers);

        String url = "http://localhost:" + port + "/api/v1/user/register";
        ResponseEntity<String> response = restTemplate.exchange(
                url, HttpMethod.POST, entity, String.class
        );
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertTrue(response.getBody().contains("success"));
    }


}
