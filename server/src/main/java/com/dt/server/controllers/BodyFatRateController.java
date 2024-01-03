package com.dt.server.controllers;

import com.dt.server.entities.BodyFatRate;
import com.dt.server.requests.BodyFatRateRequest;
import com.dt.server.requests.GetBetweenDatesRequest;
import com.dt.server.services.BodyFatRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bodyFatRate")
public class BodyFatRateController {
    @Autowired
    private BodyFatRateService bodyFatRateService;

    @PostMapping
    public BodyFatRate save(BodyFatRateRequest bodyFatRateRequest){
        return bodyFatRateService.save(bodyFatRateRequest);
    }

    @PostMapping("/all")
    public List<BodyFatRate> getAllBodyFatRateBetweenTwoDates(GetBetweenDatesRequest getBetweenDatesRequest){
        return bodyFatRateService.findAllByDateBetween(getBetweenDatesRequest);
    }
}
