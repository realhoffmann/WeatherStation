package com.example.weatherstation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeatherStationApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherStationApplication.class, args);
        //always create test data
        WeatherData.TestData();
    }

}
