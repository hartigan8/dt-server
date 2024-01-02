package com.dt.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dt.server.entities.BloodPressure;
import com.dt.server.entities.Weight;
import com.dt.server.repos.BloodPressureRepo;
import com.dt.server.requests.BloodPressureRequest;
import com.dt.server.requests.GetBetweenDatesRequest;

import java.util.List;

@Service
public class BloodPressureService {

    @Autowired
    private BloodPressureRepo bloodPressureRepo;
    @Autowired
    private UserService userService;

    public BloodPressure save(BloodPressureRequest bloodPressureRequest) {
        BloodPressure bloodPressure = new BloodPressure();
        bloodPressure.setSystolic(bloodPressureRequest.getSystolic());
        bloodPressure.setDiastolic(bloodPressureRequest.getDiastolic());
        bloodPressure.setMeasurementLocation(bloodPressureRequest.getMeasurementLocation());
        bloodPressure.setBodyPosition(bloodPressureRequest.getBodyPosition());
        bloodPressure.setUser(userService.loadUserSCH());
        return bloodPressureRepo.save(bloodPressure);
    }
    
    public List<BloodPressure> findAllByDateBetween(GetBetweenDatesRequest request) {
        Long startDate = request.getStartDate();
        Long endDate = request.getEndDate();
        Long id = request.getId();

        return bloodPressureRepo.findAllByDateBetween(id, startDate, endDate);
    }

}
