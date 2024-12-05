package com.example.WindSpeed.controller;

import com.example.WindSpeed.model.Geocode;
import com.example.WindSpeed.model.Report;
import com.example.WindSpeed.model.WindResponseDto;
import com.example.WindSpeed.service.GeocodeService;
import com.example.WindSpeed.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class WindSpeedController {

    @Autowired
    private GeocodeService geocodeService;
    @Autowired
    private ReportService reportService;
    @GetMapping("/wind/{zipCode}")
    public WindResponseDto windResponse(@PathVariable String zipCode) {
        if (zipCode == null || zipCode.length() != 5) {
            throw new IllegalArgumentException("Invalid zipcode. Must be 5 digits");
        }

        Geocode geocode = geocodeService.getLatAndLonFromZipCode(zipCode);
        if (geocode == null) {
            throw new IllegalArgumentException("Unable to fetch geocode for the given zipcode");
        }

        Report report = reportService.getReportByLonAndLat(geocode.getLat(), geocode.getLon());
        //check might be better implemented on frontend
        if (report.getWind().getGust() == 0.00) {
            return new WindResponseDto(geocode.getName(), report.getWind().getSpeed(), null);
        } else {
            return new WindResponseDto(geocode.getName(), report.getWind().getSpeed(), report.getWind().getGust());
        }
    }
}
