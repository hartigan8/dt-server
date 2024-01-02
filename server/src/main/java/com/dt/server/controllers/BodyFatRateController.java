package com.dt.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bodyFatRate")
public class BodyFatRateController {
    @Autowired
    private BodyFatRateService bodyFatRateService;

}
