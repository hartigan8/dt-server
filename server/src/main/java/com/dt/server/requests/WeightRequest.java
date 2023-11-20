package com.dt.server.requests;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

@Data
public class WeightRequest {
    private Integer measure;
    private Long date;
    private String unit;
}
