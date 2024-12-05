package com.example.WindSpeed.model;

public class WindResponseDto {
    private String location;
    private double windSpeed;
    private Double windGust; //nullable to indicate absence of gusts | might be checked on frontend

    public WindResponseDto(String location, double windSpeed, Double windGust) {
        this.location = location;
        this.windSpeed = windSpeed;
        this.windGust = windGust;
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
}
