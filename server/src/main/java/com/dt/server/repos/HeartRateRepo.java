package com.dt.server.repos;

import com.dt.server.entities.HeartRate;
import com.dt.server.entities.OxygenSaturation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HeartRateRepo extends JpaRepository<HeartRate, Long> {
    @Query(value = "SELECT * FROM heart_rate WHERE user_id = ?1 AND date BETWEEN ?2 AND ?3", nativeQuery = true)
    List<HeartRate> findAllByDateBetween(Long id, Long startDate, Long endDate);
}
