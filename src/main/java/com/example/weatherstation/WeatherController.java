package com.example.weatherstation;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    //print explanation for user
    @GetMapping("/explanation")
    public String explanation() {
        return "Willkommen bei der Wetterstation. \n" +
                "Um alle Wetterdaten anzuzeigen, geben Sie /all ein. \n" +
                "Um die Wetterdaten für eine bestimmte Stadt anzuzeigen, geben Sie /{city} ein. \n" +
                "Um neue Wetterdaten hinzuzufügen, geben Sie /add/{city}/{temperature} ein. \n";
    }

    WeatherData weatherData = new WeatherData();

    //show all weather data
    @GetMapping("/all")
    public String getAllWeatherData() {
        return WeatherData.getWeatherData().toString();
    }

    //show weather data for a specific city
    @GetMapping("/{city}")
    public String getCurrentTemperature(@PathVariable String city) {
        return WeatherData.getWeatherDataForCity(city).toString();
    }

    //method for adding new weather data
    @GetMapping("add/{city}/{temperature}")
    public String addNewWeatherData(@PathVariable("city") String city, @PathVariable("temperature") double temperature) {
        weatherData.addNew(city, temperature);
        return "Die Temperatur in " + city + " wurde auf " + temperature + " C° gesetzt.";
    }
}
