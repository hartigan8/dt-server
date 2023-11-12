package com.dt.server.repos;


import com.dt.server.entities.Water;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WaterRepo extends JpaRepository<Water, Long> {
    
}
