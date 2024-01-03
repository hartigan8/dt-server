package com.dt.server.controllers;

import com.dt.server.entities.OxygenSaturation;
import com.dt.server.requests.GetBetweenDatesRequest;
import com.dt.server.requests.OxygenSaturationRequest;
import com.dt.server.services.OxygenSaturationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/oxygenSaturation")
public class OxygenSaturationController {
    @Autowired
    private OxygenSaturationService oxygenSaturationService;

    @PostMapping
    public OxygenSaturation save(OxygenSaturationRequest oxygenSaturationRequest){
        return oxygenSaturationService.save(oxygenSaturationRequest);
    }

    @PostMapping("/all")
    public List<OxygenSaturation> getAllOxygenSaturationBetweenTwoDates(GetBetweenDatesRequest getBetweenDatesRequest){
        return oxygenSaturationService.findAllByDateBetween(getBetweenDatesRequest);
    }
}
