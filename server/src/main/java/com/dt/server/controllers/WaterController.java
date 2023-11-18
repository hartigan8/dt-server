package com.dt.server.controllers;


import com.dt.server.entities.Water;
import com.dt.server.requests.WaterRequest;
import com.dt.server.services.WaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/water")
public class WaterController {

    @Autowired
    WaterService waterService;

    @PostMapping
    public Water addWaterData(@RequestBody WaterRequest newWater){
        return waterService.saveOneWater(newWater);
    }
}
