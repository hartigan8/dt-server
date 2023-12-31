package com.dt.server.repos;

import com.dt.server.entities.Step;
import com.dt.server.entities.Weight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StepRepo extends JpaRepository<Step, Long> {
    @Query(value = "SELECT * FROM steps WHERE user_id = ?1 AND date BETWEEN ?2 AND ?3", nativeQuery = true)
    List<Weight> findAllByDateBetween(Long id, Long startDate, Long endDate);
}
