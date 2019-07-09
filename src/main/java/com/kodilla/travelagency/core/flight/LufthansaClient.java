package com.kodilla.travelagency.core.flight;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Getter
@Setter
public class LufthansaClient {
    @Value("${lufthansa.api.endpoint.prod}")
    private String lufthansaApiEndpoint;

    @Value("${lufthansa.api.key}")
    private String lufthansaApiKey;

    @Value("${lufthansa.api.token}")
    private String lufthansaApiToken;

    @Value("${lufthansa.api.secret}")
    private String lufthansaApiSecret;

    @Autowired
    private RestTemplate restTemplate;
}
