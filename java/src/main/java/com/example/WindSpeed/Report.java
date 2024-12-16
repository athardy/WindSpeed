package com.example.WindSpeed;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Report {

    @JsonProperty("wind")
    private Wind wind;

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    // Nested Wind class
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Wind {

        @JsonProperty("speed")
        private double speed;

        @JsonProperty("deg")
        private int deg;

        @JsonProperty("gust")
        private double gust;

        public double getSpeed() {
            return speed;
        }

        public void setSpeed(double speed) {
            this.speed = speed;
        }

        public int getDeg() {
            return deg;
        }

        public void setDeg(int deg) {
            this.deg = deg;
        }

        public double getGust() {
            return gust;
        }

        public void setGust(double gust) {
            this.gust = gust;
        }

        public String degToString() {
            if (deg > 337.5) {
                return "N";
            }
            if (deg > 292.5) {
                return "NW";
            }
            if (deg > 247.5) {
                return "W";
            }
            if (deg > 202.5) {
                return "SW";
            }
            if (deg > 157.5) {
                return "S";
            }
            if (deg > 122.5) {
                return "SE";
            }
            if (deg > 67.5) {
                return "E";
            }
            if (deg > 22.5) {
                return "NE";
            }
            return "";
        }
    }
}