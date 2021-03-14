package com.example.starwars.client;

import com.example.starwars.common.Utils;
import com.example.starwars.dto.GetAllPlanets;
import com.example.starwars.exceptions.GraphQLException;
import com.example.starwars.models.AllPlanets;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.inject.Inject;
import java.net.URI;

@Log4j2
@Component
public class GraphQLClient {
//    @Value("${starwars.BASE_URL}")
//    private String baseUrl;

    private final RestTemplate restTemplate;

    private final String getAllPlanetsQuery =
            "{ allPlanets { planets { name  population rotationPeriod}}}" ;
//            "allStarships { starships { name model costInCredits} }}";

    @Inject
    public GraphQLClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public AllPlanets getAllPlanets() throws GraphQLException {
        var response = restTemplate.exchange(
                getUri(),
                HttpMethod.POST,
                new HttpEntity<>(getAllPlanetsQuery, getHeaders()),
                GetAllPlanets.class
        );
        if (!response.getStatusCode().is2xxSuccessful()) {
            var message = String.format("Unable to call harness: %s", response.getStatusCode().toString());
            log.error(message);
            throw new GraphQLException(message);
        }
        if (response.getBody().getErrors() != null) {
            var message = Utils.getErrorMessage(response.getBody().getErrors());
            log.error(message);
            throw new GraphQLException(message);
        }
        var app = response.getBody().getData().getAllPlanets();
        return app;

    }

    private URI getUri() {
        return UriComponentsBuilder.fromUriString("https://swapi.apis.guru").build().toUri();
    }

    private HttpHeaders getHeaders() {
        var headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return headers;
    }

}

