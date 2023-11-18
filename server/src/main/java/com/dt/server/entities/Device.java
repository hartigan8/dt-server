package com.dt.server.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity(name = "devices")
@Data
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long activationDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
