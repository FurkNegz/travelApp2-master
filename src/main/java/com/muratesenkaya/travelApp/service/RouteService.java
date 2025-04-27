package com.muratesenkaya.travelApp.service;

import com.muratesenkaya.travelApp.dto.RouteDTO;
import com.muratesenkaya.travelApp.mapper.RouteMapper;
import com.muratesenkaya.travelApp.model.Route;
import com.muratesenkaya.travelApp.repository.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RouteService {

    private final RouteRepository routeRepository;

    public RouteDTO createRoute(RouteDTO routeDTO) {
        Route route = RouteMapper.toEntity(routeDTO);
        Route savedRoute = routeRepository.save(route);
        return RouteMapper.toDTO(savedRoute);
    }

    public List<RouteDTO> getAllRoutes() {
        List<Route> routes = routeRepository.findAll();
        return routes.stream()
                .map(RouteMapper::toDTO)
                .collect(Collectors.toList());
    }

    public RouteDTO getRouteById(Long id) {
        Route route = routeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Route not found with id: " + id));
        return RouteMapper.toDTO(route);
    }

    public void deleteRoute(Long id) {
        routeRepository.deleteById(id);
    }
}
