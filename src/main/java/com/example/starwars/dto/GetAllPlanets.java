package com.example.starwars.dto;

import com.example.starwars.models.Data;
import com.example.starwars.models.Error;
import lombok.NoArgsConstructor;


@lombok.Data
@NoArgsConstructor
public class GetAllPlanets {
    private Data data;
    private Error[] errors;

}
