package com.dt.server.services;

import com.dt.server.entities.Weight;
import com.dt.server.repos.WeightRepo;

import java.util.Optional;

//@Service
public class WeightService {

    private WeightRepo weightRepo;
    /*
    public List<Weight> getWeightById(Long patientId) {
        return weightRepository.findAllById(patientId);
    }
    */

    public Weight saveWeightData(Weight newWeight) {
        return weightRepo.save(newWeight);
    }

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

    public void deleteWeightDataById(Long patientId) {
        weightRepo.deleteById(patientId);
    }
}
