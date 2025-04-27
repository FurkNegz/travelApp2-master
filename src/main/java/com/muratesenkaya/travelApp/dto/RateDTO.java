package com.muratesenkaya.travelApp.dto;

import lombok.Data;

@Data
public class RateDTO {
    private Long id;
    private int rate;
    private Long userId;
    private Long routeId;
}
