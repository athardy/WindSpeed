package com.example.WindSpeed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/wind")
public class WindSpeedController {

    @Autowired
    private GeocodeService geocodeService;

    @Autowired
    private ReportService reportService;

    @GetMapping("/zip/{zipCode}")
    public WindResponseDto GetWindResponseByZip(@PathVariable String zipCode) {
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
            return new WindResponseDto(report.getName(), report.getWind().getSpeed(), null, report.getWind().degToString());
        } else {
            return new WindResponseDto(report.getName(), report.getWind().getSpeed(), report.getWind().getGust(), report.getWind().degToString());
        }
    }

    @GetMapping("/coordinates")
    public WindResponseDto getWindResponseByCoordinates(@RequestParam Double lat, @RequestParam Double lon) {
        if (lat == null || lon == null) {
            throw new IllegalArgumentException("Did not receive coordinates.");
        }

        Report report = reportService.getReportByLonAndLat(lat, lon);
        //check might be better implemented on frontend
        if (report.getWind().getGust() == 0.00) {
            return new WindResponseDto(report.getName(), report.getWind().getSpeed(), null, report.getWind().degToString());
        } else {
            return new WindResponseDto(report.getName(), report.getWind().getSpeed(), report.getWind().getGust(), report.getWind().degToString());
        }
    }
}
