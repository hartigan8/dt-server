package com.dt.server.services;

import com.dt.server.entities.User;
import com.dt.server.entities.Weight;
import com.dt.server.repos.WeightRepo;
import com.dt.server.requests.GetBetweenDatesRequest;
import com.dt.server.requests.WeightRequest;
import com.dt.server.security.UserDetailsImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeightService {

    @Autowired
    private WeightRepo weightRepo;
    @Autowired
    private UserService userService;




    public Weight saveWeightData(WeightRequest newWeight) {
        Weight w = new Weight();
        w.setDate(newWeight.getDate());
        w.setUnit(newWeight.getUnit());
        w.setMeasure(newWeight.getMeasure());
        User user = userService.loadUserSCH();
        w.setUser(user);
        return weightRepo.save(w);
    }
    public void deleteWeightDataById(Long patientId) {
        weightRepo.deleteById(patientId);
    }
    public List<Weight> findAllByDateBetween(GetBetweenDatesRequest twoDate) {
        Long startDate = twoDate.getStartDate();
        Long endDate = twoDate.getEndDate();
        Long id = twoDate.getId();

        return weightRepo.findAllByDateBetween(id, startDate, endDate);
    }
}
