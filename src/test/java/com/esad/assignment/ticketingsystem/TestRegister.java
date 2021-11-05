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

import java.util.Random;

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

        registerRequest.setFirstName("Test");
        registerRequest.setLastName("Passenger");

        String emailSuffix = getRandomNumber(999, 3);
        String nic = getRandomNumber(9999, 10);
        String mobile = getRandomNumber(999, 10);

        registerRequest.setEmail(String.format("unitTestUser%s@gmail.com", emailSuffix));
        registerRequest.setMobileNumber(mobile);
        registerRequest.setNic(nic);

        HttpEntity<UserRegisterRequest> entity = new HttpEntity<UserRegisterRequest>(registerRequest, headers);

        String url = "http://localhost:" + port + "/api/v1/user/register";
        ResponseEntity<String> response = restTemplate.exchange(
                url, HttpMethod.POST, entity, String.class
        );
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertTrue(response.getBody().contains("success"));
    }

    private String getRandomNumber(int range, int length) {
        Random rnd = new Random();
        int number = rnd.nextInt(range);
        return String.format("%0"+ length +"d", number);
    }
}