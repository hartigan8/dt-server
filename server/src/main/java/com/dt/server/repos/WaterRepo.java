package com.dt.server.repos;


import com.dt.server.entities.Water;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WaterRepo extends JpaRepository<Water, Long> {


    @Query(value = "SELECT * FROM water WHERE date BETWEEN ?1 AND ?2", nativeQuery = true)
    List<Water> findAllByDateBetween(Long startDate, Long endDate);
    
}
