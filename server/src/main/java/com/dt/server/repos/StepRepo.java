package com.dt.server.repos;

import com.dt.server.entities.Step;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StepRepo extends JpaRepository<Step, Long> {
}
