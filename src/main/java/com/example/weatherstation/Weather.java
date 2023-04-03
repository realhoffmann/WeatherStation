package com.example.weatherstation;

public class Weather {
    private String city;
    private double temperature;

    public Weather(String city, double temperature) {
        this.city = city;
        this.temperature = temperature;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Die aktuelle Temperatur in " + city + " beträgt " + temperature + " C° \n";
    }


}
