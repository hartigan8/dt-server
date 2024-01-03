package com.dt.server.services;

import com.dt.server.entities.BodyFatRate;
import com.dt.server.entities.User;
import com.dt.server.entities.Weight;
import com.dt.server.repos.BodyFatRateRepo;
import com.dt.server.requests.BodyFatRateRequest;
import com.dt.server.requests.GetBetweenDatesRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BodyFatRateService {
    @Autowired
    private UserService userService;
    @Autowired
    private BodyFatRateRepo bodyFatRateRepo;

    public BodyFatRate save(BodyFatRateRequest bodyFatRateRequest){
        User user = userService.loadUserSCH();
        BodyFatRate bodyFatRate = new BodyFatRate();
        bodyFatRate.setBodyFatRate(bodyFatRateRequest.getBodyFatRate());
        bodyFatRate.setTime(bodyFatRateRequest.getTime());
        bodyFatRate.setUser(user);
        return bodyFatRateRepo.save(bodyFatRate);

    }

    public List<BodyFatRate> findAllByDateBetween(GetBetweenDatesRequest twoDate) {
        Long startDate = twoDate.getStartDate();
        Long endDate = twoDate.getEndDate();
        Long id = twoDate.getId();
        return bodyFatRateRepo.findAllByDateBetween(id, startDate, endDate);
    }

    
}
