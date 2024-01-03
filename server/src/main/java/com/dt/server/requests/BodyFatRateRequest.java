package com.dt.server.requests;

import lombok.Data;

@Data
public class BodyFatRateRequest {
    private Long time;
    private Double bodyFatRate;
}
