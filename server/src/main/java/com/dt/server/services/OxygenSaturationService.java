package com.dt.server.services;

import com.dt.server.entities.BodyFatRate;
import com.dt.server.entities.OxygenSaturation;
import com.dt.server.entities.User;
import com.dt.server.repos.OxygenSaturationRepo;
import com.dt.server.requests.GetBetweenDatesRequest;
import com.dt.server.requests.OxygenSaturationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OxygenSaturationService {
    @Autowired
    private UserService userService;
    @Autowired
    private OxygenSaturationRepo oxygenSaturationRepo;

    public OxygenSaturation save(OxygenSaturationRequest oxygenSaturationRequest){
        OxygenSaturation oxygenSaturation = new OxygenSaturation();
        User user = userService.loadUserSCH();
        oxygenSaturation.setUser(user);
        oxygenSaturation.setValue(oxygenSaturationRequest.getValue());
        oxygenSaturation.setTime(oxygenSaturationRequest.getTime());
        return oxygenSaturationRepo.save(oxygenSaturation);
    }

    public List<OxygenSaturation> findAllByDateBetween(GetBetweenDatesRequest twoDate) {
        Long startDate = twoDate.getStartDate();
        Long endDate = twoDate.getEndDate();
        Long id = twoDate.getId();
        return oxygenSaturationRepo.findAllByDateBetween(id, startDate, endDate);
    }
}
