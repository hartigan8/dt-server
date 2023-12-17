package com.dt.server.services;

import com.dt.server.entities.User;
import com.dt.server.entities.Water;
import com.dt.server.repos.WaterRepo;
import com.dt.server.requests.GetBetweenDatesRequest;
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
        User user = userService.loadUserSCH();
        water.setUser(user);
        water.setDate(waterRequest.getDate());
        water.setVolume(waterRequest.getVolume());

        return waterRepo.save(water);
    }


    public List<Water> findAllByDateBetween(GetBetweenDatesRequest twoDate) {
        Long startDate = twoDate.getStartDate();
        Long endDate = twoDate.getEndDate();
        Long id = twoDate.getId();
        return waterRepo.findAllByDateBetween(id, startDate, endDate);
    }
}
