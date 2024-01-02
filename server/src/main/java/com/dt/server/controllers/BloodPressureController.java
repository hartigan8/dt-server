package com.dt.server.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dt.server.entities.BloodPressure;
import com.dt.server.requests.BloodPressureRequest;
import com.dt.server.requests.GetBetweenDatesRequest;
import com.dt.server.services.BloodPressureService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@RestController
@RequestMapping("/bloodPressure")
public class BloodPressureController {

    @Autowired
    private BloodPressureService bloodPressureService;

    @PostMapping
    public BloodPressure postMethodName(@RequestBody BloodPressureRequest bloodPressureRequest) {
        
        return bloodPressureService.save(bloodPressureRequest);
    }

    @PostMapping("/all")
    public List<BloodPressure> postMethodName(@RequestBody GetBetweenDatesRequest twoDates) {
        
        return bloodPressureService.findAllByDateBetween(twoDates);
    }
    
    
}
