package com.dt.server.requests;

import lombok.Data;

@Data
public class StepRequest {
    private Long startTime;
    private Long endTime;
    private Integer count;


}
