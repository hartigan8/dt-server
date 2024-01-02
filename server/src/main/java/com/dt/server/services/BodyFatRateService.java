package com.dt.server.services;

import com.dt.server.entities.BodyFatRate;
import com.dt.server.repos.BodyFatRateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BodyFatRateService {
    @Autowired
    private UserService userService;
    @Autowired
    private BodyFatRateRepo bodyFatRateRepo;

    public BodyFatRate save(BodyFatRate bodyFatRate)
        

    
}
