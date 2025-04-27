package com.muratesenkaya.travelApp.service;

import com.muratesenkaya.travelApp.dto.LocationDTO;
import com.muratesenkaya.travelApp.mapper.LocationMapper;
import com.muratesenkaya.travelApp.model.Location;
import com.muratesenkaya.travelApp.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;

    public LocationDTO createLocation(LocationDTO locationDTO) {
        Location location = LocationMapper.toEntity(locationDTO);
        Location savedLocation = locationRepository.save(location);
        return LocationMapper.toDTO(savedLocation);
    }

    public List<LocationDTO> getAllLocations() {
        return locationRepository.findAll().stream()
                .map(LocationMapper::toDTO)
                .collect(Collectors.toList());
    }

    public LocationDTO getLocationById(Long id) {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Location not found"));
        return LocationMapper.toDTO(location);
    }

    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }
}
