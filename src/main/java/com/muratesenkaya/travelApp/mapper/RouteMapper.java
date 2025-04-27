package com.muratesenkaya.travelApp.mapper;
import com.muratesenkaya.travelApp.dto.RouteDTO;
import com.muratesenkaya.travelApp.model.Route;
import com.muratesenkaya.travelApp.model.Tag;

import java.util.stream.Collectors;

public class RouteMapper {

    public static RouteDTO toDTO(Route route) {
        RouteDTO dto = new RouteDTO();
        dto.setId(route.getId());
        dto.setHead(route.getHead());
        dto.setDescription(route.getDescription());
        dto.setDate(route.getDate());
        if (route.getTags() != null) {
            dto.setTags(route.getTags().stream()
                    .map(Tag::getName)
                    .collect(Collectors.toList()));
        }
        return dto;
    }

    public static Route toEntity(RouteDTO dto) {
        Route route = new Route();
        route.setId(dto.getId());
        route.setHead(dto.getHead());
        route.setDescription(dto.getDescription());
        route.setDate(dto.getDate());
        // Tagleri burada set etmiyoruz çünkü sadece isim var. İstersen advanced bir yöntem kurarız.
        return route;
    }
}

