package com.dt.server.services;

import com.dt.server.entities.Water;
import com.dt.server.repos.WaterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WaterService {
    @Autowired
    private WaterRepo waterRepo;


    public Water saveOneWater(Water water){
        return waterRepo.save(water);
    }
}
