package com.example.WindSpeed;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

@Service
public class ReportService {
    @Value("${app.report.api.url}")
    private String API_BASE_URL;

    @Value("${app.owm.api.key}")
    private String API_KEY;

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
