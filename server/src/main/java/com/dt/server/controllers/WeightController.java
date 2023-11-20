package com.dt.server.controllers;

import com.dt.server.entities.Weight;
import com.dt.server.requests.WeightRequest;
import com.dt.server.services.WeightService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/weight")
public class WeightController {

    private WeightService weightService;

    public WeightController(WeightService weightService) {
        this.weightService = weightService;
    }


    @PostMapping
    public Weight addWeightData(@RequestBody WeightRequest newWeight){
        return weightService.saveWeightData(newWeight);
    }




}
