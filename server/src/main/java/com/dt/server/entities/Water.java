package com.dt.server.entities;


import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table (name ="water")
@Data

public class Water {


    Long id;

    @Id
    Long time; // unix time

    Integer volume;
}
