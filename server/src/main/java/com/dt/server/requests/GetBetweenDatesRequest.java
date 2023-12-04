package com.dt.server.requests;

import lombok.Data;

@Data
public class GetBetweenDatesRequest {
    private Long startDate;
    private Long endDate;
}
