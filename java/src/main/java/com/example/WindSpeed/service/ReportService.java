package com.example.WindSpeed.service;

import com.example.WindSpeed.model.Report;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

@Service
public class ReportService {

    private final String API_BASE_URL = "https://api.openweathermap.org/data/2.5/weather";
    private final String API_KEY = "f078ca176c8b3ef2233c682be77ba072";
    private final RestTemplate restTemplate = new RestTemplate();

    //method to get wind data from latitude and longitude input via API
    public Report getReportByLonAndLat(double lat, double lon) {
        Report report = null;
        try {
            report = restTemplate.getForObject(API_BASE_URL + "?lat=" + lat + "&lon=" + lon + "&appid=" + API_KEY + "&units=imperial", Report.class);
        } catch (RestClientResponseException e) {
            System.out.println(e.getStatusCode() + ":" + e.getStatusText());
        } catch (ResourceAccessException e) {
            System.out.println(e.getMessage());
        }
        return report;
    }


}
