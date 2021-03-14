package com.example.starwars.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Planet {
    private int rotationPeriod;
    private int population;
    private int name;
}
