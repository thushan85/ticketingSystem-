package com.esad.assignment.ticketingsystem;

import com.esad.assignment.ticketingsystem.request.DriverTripRequest;
import com.esad.assignment.ticketingsystem.request.JourneyRequest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class TestStartTrip {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    HttpHeaders headers = new HttpHeaders();

    @Test
    public void contextLoads() throws RuntimeException {
        DriverTripRequest tripRequest = new DriverTripRequest();
        tripRequest.setTripId(0);
        tripRequest.setVehicleId(1);

        HttpEntity<DriverTripRequest> entity = new HttpEntity<>(tripRequest, headers);
        String url = "http://localhost:" + port + "/api/v1/driver//trip/start";
        ResponseEntity<String> response = restTemplate.exchange(
                url, HttpMethod.POST, entity, String.class
        );
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        log.info(response.getBody());
        Assertions.assertTrue(response.getBody().contains("success"));
    }
}
