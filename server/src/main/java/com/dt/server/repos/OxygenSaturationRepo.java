package com.dt.server.repos;

import com.dt.server.entities.OxygenSaturation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OxygenSaturationRepo extends JpaRepository<OxygenSaturation, Long> {
    @Query(value = "SELECT * FROM oxygen_saturation WHERE user_id = ?1 AND date BETWEEN ?2 AND ?3", nativeQuery = true)
    List<OxygenSaturation> findAllByDateBetween(Long id, Long startDate, Long endDate);
}
