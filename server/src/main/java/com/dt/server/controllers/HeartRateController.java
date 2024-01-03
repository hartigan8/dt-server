package com.dt.server.controllers;

import com.dt.server.entities.HeartRate;
import com.dt.server.requests.GetBetweenDatesRequest;
import com.dt.server.requests.HeartRateRequest;
import com.dt.server.services.HeartRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/heartRate")
public class HeartRateController {
    @Autowired
    private HeartRateService heartRateService;

    @PostMapping
    public HeartRate save(HeartRateRequest heartRateRequest){
        return heartRateService.save(heartRateRequest);
    }

    @PostMapping("/all")
    public List<HeartRate> getAllHeartRatesBetweenTwoDates(GetBetweenDatesRequest getBetweenDatesRequest){
        return heartRateService.findAllByDateBetween(getBetweenDatesRequest);
    }
}
