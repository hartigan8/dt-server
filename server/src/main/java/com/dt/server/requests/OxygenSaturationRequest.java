package com.dt.server.requests;

import lombok.Data;

@Data
public class OxygenSaturationRequest {
    private Long time;
    private Double value;
}
