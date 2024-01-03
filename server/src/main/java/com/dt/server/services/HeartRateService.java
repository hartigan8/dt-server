package com.dt.server.services;

import com.dt.server.entities.BodyFatRate;
import com.dt.server.entities.HeartRate;
import com.dt.server.entities.User;
import com.dt.server.repos.HeartRateRepo;
import com.dt.server.requests.GetBetweenDatesRequest;
import com.dt.server.requests.HeartRateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeartRateService {
    @Autowired
    private UserService userService;
    @Autowired
    private HeartRateRepo heartRateRepo;
    public HeartRate save(HeartRateRequest heartRateRequest){
        HeartRate heartRate = new HeartRate();
        User user = userService.loadUserSCH();
        heartRate.setAvg(heartRateRequest.getAvg());
        heartRate.setUser(user);
        heartRate.setMax(heartRateRequest.getMax());
        heartRate.setMin(heartRateRequest.getMin());
        heartRate.setCount(heartRateRequest.getCount());
        heartRate.setEndTime(heartRateRequest.getEndTime());
        heartRate.setStartTime(heartRateRequest.getStartTime());
        return heartRateRepo.save(heartRate);
    }
    public List<HeartRate> findAllByDateBetween(GetBetweenDatesRequest twoDate) {
        Long startDate = twoDate.getStartDate();
        Long endDate = twoDate.getEndDate();
        Long id = twoDate.getId();
        return heartRateRepo.findAllByDateBetween(id, startDate, endDate);
    }
}
