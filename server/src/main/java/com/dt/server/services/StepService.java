package com.dt.server.services;

import com.dt.server.entities.Step;
import com.dt.server.entities.Weight;
import com.dt.server.repos.StepRepo;
import com.dt.server.requests.GetBetweenDatesRequest;
import com.dt.server.requests.StepRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StepService {
    @Autowired
    private StepRepo stepRepo;
    @Autowired
    private UserService userService;

    public Step addStepData(StepRequest stepRequest){
        Step step = new Step();
        step.setCount(stepRequest.getCount());
        step.setStartTime(stepRequest.getStartTime());
        step.setEndTime(stepRequest.getEndTime());
        step.setUser(userService.loadUserSCH());
        return stepRepo.save(step);
    }

    public List<Weight> findAllByDateBetween(GetBetweenDatesRequest request) {
        Long startDate = request.getStartDate();
        Long endDate = request.getEndDate();
        Long id = request.getId();

        return stepRepo.findAllByDateBetween(id, startDate, endDate);
    }
}
