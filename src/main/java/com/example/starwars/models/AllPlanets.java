package com.example.starwars.models;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class AllPlanets {
    private List<Planet> Planets;
}
