package com.example.starwars.service;

import com.example.starwars.client.GraphQLClient;
import com.example.starwars.exceptions.GraphQLException;
import com.example.starwars.models.AllPlanets;
import com.example.starwars.models.Planet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.lang.management.PlatformLoggingMXBean;
import java.util.List;

@Slf4j
@Service
public class PlanetsService {
    private final GraphQLClient graphQLClient;

    @Inject
    public PlanetsService(final graphQLClient){
        this.graphQLClient = graphQLClient;
    }
    public AllPlanets getAllPlanets(){
        try {
            return graphQLClient.getAllPlanets();
        } catch (GraphQLException e) {
            e.printStackTrace();
            return null;
        }
    }
 }
