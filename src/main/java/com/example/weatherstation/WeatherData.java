package com.example.weatherstation;

import java.util.ArrayList;

public class WeatherData {

    //weahter ArrayList
    static ArrayList<Weather> weatherData = new ArrayList<Weather>();

    //method to get weather data
    public static ArrayList<Weather> getWeatherData() {
        return weatherData;
    }

    //method to get weather data for city
    public static ArrayList<Weather> getWeatherDataForCity(String city) {
        ArrayList<Weather> weatherDataForCity = new ArrayList<Weather>();
        for (Weather weather : weatherData) {
            if (weather.getCity().equals(city)) {
                weatherDataForCity.add(weather);
            }
        }
        return weatherDataForCity;
    }

    //test data
    public static void TestData() {
        weatherData.add(new Weather("Wien", 20.0));
        weatherData.add(new Weather("Graz", 18.0));
        weatherData.add(new Weather("Linz", 15.0));

    }

    //add new weather data
    public void addNew(String city, double temperature) {
        weatherData.add(new Weather(city, temperature));
    }

    public void addNew(Weather mockWeather) {
        weatherData.add(mockWeather);
    }
}
