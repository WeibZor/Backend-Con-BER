package com.example.sstretencion.controller;

import com.example.sstretencion.service.SstIndicatorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/indicators")
public class IndicatorsController {

    @Autowired
    private SstIndicatorsService indicatorsService;

    @GetMapping
    public Map<String, Double> getIndicators() {
        Map<String, Double> indicators = new HashMap<>();
        indicators.put("accidentRate", indicatorsService.calculateAccidentRate());
        indicators.put("absenteeismRate", indicatorsService.calculateAbsenteeismRate());
        return indicators;
    }
}