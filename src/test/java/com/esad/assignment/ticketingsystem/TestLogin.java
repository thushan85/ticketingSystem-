package com.esad.assignment.ticketingsystem;

import com.esad.assignment.ticketingsystem.controller.user.UserController;
import com.esad.assignment.ticketingsystem.model.enums.UserType;
import com.esad.assignment.ticketingsystem.request.UserLoginRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestLogin {
    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    HttpHeaders headers = new HttpHeaders();

    @Test
    public void contextLoads() throws RuntimeException {

        UserLoginRequest loginRequest = new UserLoginRequest();
        loginRequest.setUserType(UserType.PASSENGER);
        loginRequest.setMobileNumber("0717358713");

        HttpEntity<UserLoginRequest> entity = new HttpEntity<UserLoginRequest>(loginRequest, headers);

        String url = "http://localhost:" + port + "/api/v1/user/login";
        ResponseEntity<String> response = restTemplate.exchange(
            url, HttpMethod.POST, entity, String.class
        );
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertTrue(response.getBody().contains("success"));
    }
}
