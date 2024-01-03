package com.dt.server.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity(name = "oxygen_saturation")
@Data
public class OxygenSaturation {
    @Id
    private Long time;
    private Double value;



    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;
}
