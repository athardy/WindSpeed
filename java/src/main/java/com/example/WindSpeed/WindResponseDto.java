package com.example.WindSpeed;

public class WindResponseDto {
    private String location;
    private double windSpeed;
    private Double windGust; //nullable to indicate absence of gusts | might be checked on frontend
    private String windDeg;

    public WindResponseDto(String location, double windSpeed, Double windGust, String windDeg) {
        this.location = location;
        this.windSpeed = windSpeed;
        this.windGust = windGust;
        this.windDeg = windDeg;
    }

    public String getLocation() {
        return location;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public Double getWindGust() {
        return windGust;
    }

    public String getWindDeg() {
        return windDeg;
    }
}
