package com.muratesenkaya.travelApp.controller;

import com.muratesenkaya.travelApp.dto.RateDTO;
import com.muratesenkaya.travelApp.service.RateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rates")
@RequiredArgsConstructor
public class RateController {

    private final RateService rateService;

    @PostMapping
    public ResponseEntity<RateDTO> createRate(@RequestBody RateDTO rateDTO) {
        return ResponseEntity.ok(rateService.createRate(rateDTO));
    }

    @GetMapping
    public ResponseEntity<List<RateDTO>> getAllRates() {
        return ResponseEntity.ok(rateService.getAllRates());
    }
}
