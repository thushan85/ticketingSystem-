package com.esad.assignment.ticketingsystem;

import com.esad.assignment.ticketingsystem.request.JourneyRequest;
import com.esad.assignment.ticketingsystem.request.UserRegisterRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestScanTicket {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    HttpHeaders headers = new HttpHeaders();

    @Test
    public void contextLoads() throws RuntimeException {
        JourneyRequest journeyRequest = new JourneyRequest();
        journeyRequest.setLat("6.8649");
        journeyRequest.setLng("79.8997");
        journeyRequest.setPassengerId(100);
        journeyRequest.setTripId(100);

        HttpEntity<JourneyRequest> entity = new HttpEntity<JourneyRequest>(journeyRequest, headers);
        String url = "http://localhost:" + port + "/api/v1/driver/scan-ticket";
        ResponseEntity<String> response = restTemplate.exchange(
            url, HttpMethod.POST, entity, String.class
        );
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertTrue(response.getBody().contains("success"));
    }
}
