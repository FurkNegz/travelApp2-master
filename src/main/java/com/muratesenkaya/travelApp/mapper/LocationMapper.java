package com.muratesenkaya.travelApp.mapper;

import com.muratesenkaya.travelApp.dto.LocationDTO;
import com.muratesenkaya.travelApp.model.Location;

public class LocationMapper {

    public static LocationDTO toDTO(Location location) {
        LocationDTO dto = new LocationDTO();
        dto.setId(location.getId());
        dto.setLatitude(location.getLatitude());
        dto.setLongitude(location.getLongitude());
        return dto;
    }

    public static Location toEntity(LocationDTO dto) {
        Location location = new Location();
        location.setId(dto.getId());
        location.setLatitude(dto.getLatitude());
        location.setLongitude(dto.getLongitude());
        return location;
    }
}
