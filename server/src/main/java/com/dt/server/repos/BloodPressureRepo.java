package com.dt.server.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dt.server.entities.BloodPressure;

import java.util.List;


public interface BloodPressureRepo extends JpaRepository<BloodPressure, Long> {
    @Query(value = "SELECT * FROM blood_pressures WHERE user_id = ?1 AND date BETWEEN ?2 AND ?3", nativeQuery = true)
    List<BloodPressure> findAllByDateBetween(Long id, Long startDate, Long endDate);
}
