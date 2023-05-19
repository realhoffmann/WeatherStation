package com.example.weatherstation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class WeatherDataTest {
    private WeatherData weatherData;
    private Weather mockWeather;

    @BeforeEach
    public void setup() {
        weatherData = new WeatherData();
        mockWeather = Mockito.mock(Weather.class);
        when(mockWeather.getCity()).thenReturn("Test City");
        when(mockWeather.toString()).thenReturn("Test Weather");
        weatherData.addNew(mockWeather);
    }

    @Test
    public void testGetWeatherDataForCity() {
        ArrayList<Weather> result = weatherData.getWeatherDataForCity("Test City");
        assertEquals(1, result.size());
        assertEquals("Test Weather", result.get(0).toString());
    }
}


