package com.dt.server.requests;

import lombok.Data;

@Data
public class BloodPressureRequest {
    private Long time;
    private Integer bodyPosition;
    private Integer measurementLocation;
    private Double systolic;
    private Double diastolic;
}
