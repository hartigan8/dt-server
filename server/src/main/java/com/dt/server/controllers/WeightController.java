package com.dt.server.controllers;

import com.dt.server.entities.Weight;
import com.dt.server.services.WeightService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
//@RequestMapping("/weight")

public class WeightController {
    /*
    private WeightService weightService;

    public WeightController(WeightService weightService) {
        this.weightService = weightService;
    }

    @GetMapping("/{patientId}")
    public List<Weight> getWeightDataById(@PathVariable Long patinetId){
        return weightService.getWeightById(patinetId);
    }

    @PostMapping
    public Weight addWeightData(@RequestBody Weight newWeight){
        return weightService.saveWeightData(newWeight);
    }

    @PutMapping("{patientId}")
    public Weight updateWeightData(@PathVariable Long patiendId, @RequestBody Weight newWeight){
        return weightService.updateWeightData(patiendId,newWeight);
    }

    @DeleteMapping("/{patientId}")
    public void deleteWeightData(@PathVariable Long patientId){
        weightService.deleteWeightDataById(patientId);
    }
    */
}
