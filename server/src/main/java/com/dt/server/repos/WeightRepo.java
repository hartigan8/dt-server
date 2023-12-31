package com.dt.server.repos;

import com.dt.server.entities.Weight;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WeightRepo extends JpaRepository<Weight,Long> {

    @Query(value = "SELECT * FROM weights WHERE user_id = ?1 AND date BETWEEN ?2 AND ?3", nativeQuery = true)
    List<Weight> findAllByDateBetween(Long id, Long startDate, Long endDate);


}
