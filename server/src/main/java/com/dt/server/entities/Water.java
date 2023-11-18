package com.dt.server.entities;


import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table (name ="water")
@Data

public class Water {


    @Id
    private Long date; // unix time

    private Integer volume;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}
