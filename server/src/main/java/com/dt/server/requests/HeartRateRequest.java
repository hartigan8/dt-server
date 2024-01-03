package com.dt.server.requests;

import lombok.Data;

@Data
public class HeartRateRequest {
    private Long startTime;
    private Long endTime;
    private Integer max;
    private Integer min;
    private Integer avg;
    private Integer count;
}
