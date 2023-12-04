package com.dt.server.repos;

import com.dt.server.entities.Weight;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WeightRepo extends JpaRepository<Weight,Long> {

    @Query(value = "SELECT * FROM weight WHERE date BETWEEN ?1 AND ?2", nativeQuery = true)
    List<Weight> findAllByDateBetween(Long startDate, Long endDate);


}
