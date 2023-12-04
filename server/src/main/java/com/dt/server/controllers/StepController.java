package com.dt.server.controllers;

import com.dt.server.entities.Step;
import com.dt.server.requests.StepRequest;
import com.dt.server.services.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/step")
public class StepController {

    @Autowired
    private StepService stepService;
    @PostMapping
    public Step addStepData(StepRequest stepRequest){

        return stepService.addStepData(stepRequest);
    }
}
