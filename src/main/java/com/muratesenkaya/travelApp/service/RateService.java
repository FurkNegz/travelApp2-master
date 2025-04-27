package com.muratesenkaya.travelApp.service;

import com.muratesenkaya.travelApp.dto.RateDTO;
import com.muratesenkaya.travelApp.mapper.RateMapper;
import com.muratesenkaya.travelApp.model.Rate;
import com.muratesenkaya.travelApp.model.Route;
import com.muratesenkaya.travelApp.model.User;
import com.muratesenkaya.travelApp.repository.RateRepository;
import com.muratesenkaya.travelApp.repository.RouteRepository;
import com.muratesenkaya.travelApp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RateService {

    private final RateRepository rateRepository;
    private final UserRepository userRepository;
    private final RouteRepository routeRepository;

    public RateDTO createRate(RateDTO rateDTO) {
        User user = userRepository.findById(rateDTO.getUserId()).orElseThrow();
        Route route = routeRepository.findById(rateDTO.getRouteId()).orElseThrow();
        Rate rate = RateMapper.toEntity(rateDTO, user, route);
        Rate saved = rateRepository.save(rate);
        return RateMapper.toDTO(saved);
    }

    public List<RateDTO> getAllRates() {
        return rateRepository.findAll().stream()
                .map(RateMapper::toDTO)
                .collect(Collectors.toList());
    }
}
