package com.dt.server.services;

import com.dt.server.entities.Water;
import com.dt.server.repos.WaterRepo;
import com.dt.server.requests.WaterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WaterService {
    @Autowired
    private WaterRepo waterRepo;
    @Autowired private UserService userService;


    public Water saveOneWater(WaterRequest waterRequest){
        Water water = new Water();
        try {
            water.setUser(userService.getOneUserById(waterRequest.getUserId()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        water.setDate(waterRequest.getDate());
        water.setVolume(waterRequest.getVolume());

        return waterRepo.save(water);
    }
}
