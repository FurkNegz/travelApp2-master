package com.muratesenkaya.travelApp.mapper;

import com.muratesenkaya.travelApp.dto.RateDTO;
import com.muratesenkaya.travelApp.model.Rate;
import com.muratesenkaya.travelApp.model.Route;
import com.muratesenkaya.travelApp.model.User;

public class RateMapper {

    public static RateDTO toDTO(Rate rate) {
        RateDTO dto = new RateDTO();
        dto.setId(rate.getId());
        dto.setRate(rate.getRate());
        dto.setUserId(rate.getUser().getId());
        dto.setRouteId(rate.getRoute().getId());
        return dto;
    }

    public static Rate toEntity(RateDTO dto, User user, Route route) {
        Rate rate = new Rate();
        rate.setId(dto.getId());
        rate.setRate(dto.getRate());
        rate.setUser(user);
        rate.setRoute(route);
        return rate;
    }
}
