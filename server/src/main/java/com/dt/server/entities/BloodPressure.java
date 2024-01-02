package com.dt.server.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity(name = "blood_pressures")
@Data
public class BloodPressure {
    private Long time;
    private Integer bodyPosition;
    private Integer measurementLocation;
    private Double systolic;
    private Double diastolic;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;
}
