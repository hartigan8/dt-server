package com.dt.server.requests;

import lombok.Data;

@Data
public class WeightRequest {
    private Float measure;
    private Long date;
    private String unit;
}
