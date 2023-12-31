package com.dt.server.repos;


import com.dt.server.entities.Water;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WaterRepo extends JpaRepository<Water, Long> {


    @Query(value = "SELECT * FROM waters WHERE user_id = ?1 AND date BETWEEN ?2 AND ?3", nativeQuery = true)
    List<Water> findAllByDateBetween(Long id, Long startDate, Long endDate);
    
}
