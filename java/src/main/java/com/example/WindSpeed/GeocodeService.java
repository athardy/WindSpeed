package com.example.WindSpeed;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

@Service
public class GeocodeService {
    @Value("${app.geocode.api.url}")
    private String API_BASE_URL;

    @Value("${app.owm.api.key}")
    private String API_KEY;

    private final RestTemplate restTemplate = new RestTemplate();

    //method to get latitude and longitude from zipcode input via API
    public Geocode getLatAndLonFromZipCode(String zipCode) {
        Geocode geocode = null;
        try {
            geocode = restTemplate.getForObject(API_BASE_URL + "?zip=" + zipCode + "&appid=" + API_KEY, Geocode.class);
        } catch (RestClientResponseException e) {
            System.out.println();
            System.out.println(e.getStatusCode() + ": (Zipcode is likely invalid)");
            System.out.println();
        } catch (ResourceAccessException e) {
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println();
        }
        return geocode;
    }

    //possible future method (implementation) for city/state
//    public Geocode getLatAndLonFromCityState(String city, String state) {
//        Geocode geocode = null;
//        try {
//            geocode = restTemplate.getForObject(API_BASE_URL + "direct?q=" + city + "," + state + "&appid=" + API_KEY, Geocode.class);
//        } catch (RestClientResponseException e) {
//            System.out.println();
//            System.out.println(e.getStatusCode() + ": (City,State is invalid)");
//            System.out.println();
//        } catch (ResourceAccessException e) {
//            System.out.println();
//            System.out.println(e.getMessage());
//            System.out.println();
//        }
//        return geocode;
//    }
}
