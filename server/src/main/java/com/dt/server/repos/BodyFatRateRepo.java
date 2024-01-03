package com.dt.server.repos;

import com.dt.server.entities.BodyFatRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BodyFatRateRepo extends JpaRepository<BodyFatRate, Long> {
    @Query(value = "SELECT * FROM body_fat_rates WHERE user_id = ?1 AND date BETWEEN ?2 AND ?3", nativeQuery = true)
    List<BodyFatRate> findAllByDateBetween(Long id, Long startDate, Long endDate);
}
