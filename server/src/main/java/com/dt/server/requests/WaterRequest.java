package com.dt.server.requests;

import lombok.Data;

@Data
public class WaterRequest {
    private Long userId;
    private Long date;
    private Integer volume;
}
