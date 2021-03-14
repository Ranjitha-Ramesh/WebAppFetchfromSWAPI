package com.example.starwars.controller;

import com.example.starwars.models.AllPlanets;
import com.example.starwars.service.PlanetsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@RequestMapping("/api")
public class StarWarsController {
    private final PlanetsService planetsService;

    @Inject
    public StarWarsController(PlanetsService planetsService){
        this.planetsService = planetsService;
    }

    @GetMapping("/all")
    public AllPlanets getAllPlanets(){
        return planetsService.getAllPlanets();
    }

}
