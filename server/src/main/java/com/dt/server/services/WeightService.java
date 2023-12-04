package com.dt.server.services;

import com.dt.server.entities.User;
import com.dt.server.entities.Weight;
import com.dt.server.repos.WeightRepo;
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
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            User user = userService.getOneUserById(((UserDetailsImp) auth.getPrincipal()).getId());
            w.setUser(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return weightRepo.save(w);
    }
    /*
    public Weight updateWeightData(Long patientId, Weight newWeight) {
    Optional<Weight> weight = weightRepo.findById(patientId);
    if(weight.isPresent()){
        Weight foundedWeight = weight.get();
        foundedWeight.setResult(newWeight.getResult());
        foundedWeight.setWeightType(newWeight.getWeightType());
        foundedWeight.setTargetWeight(newWeight.getTargetWeight());
        weightRepo.save(foundedWeight);
        return foundedWeight;
    }
    else return null;

    }
    */
    public void deleteWeightDataById(Long patientId) {
        weightRepo.deleteById(patientId);
    }
    public List<Weight> findAllByDateBetween(Long startDate, Long endDate) {
        return weightRepo.findAllByDateBetween(startDate, endDate);
    }
}
