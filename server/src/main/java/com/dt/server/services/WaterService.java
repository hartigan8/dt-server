package com.dt.server.services;

import com.dt.server.entities.User;
import com.dt.server.entities.Water;
import com.dt.server.repos.WaterRepo;
import com.dt.server.requests.WaterRequest;
import com.dt.server.security.UserDetailsImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaterService {
    @Autowired
    private WaterRepo waterRepo;
    @Autowired private UserService userService;


    public Water saveOneWater(WaterRequest waterRequest){
        Water water = new Water();
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            User user = userService.getOneUserById(((UserDetailsImp) auth.getPrincipal()).getId());
            water.setUser(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        water.setDate(waterRequest.getDate());
        water.setVolume(waterRequest.getVolume());

        return waterRepo.save(water);
    }


    public List<Water> findAllByDateBetween(Long startDate, Long endDate) {
        return waterRepo.findAllByDateBetween(startDate, endDate);
    }
}
