package com.example.weatherstation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class WeatherControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testExplanation() throws Exception {
        WeatherData.TestData();
        mockMvc.perform(get("/weather/explanation"))
                .andExpect(status().isOk())
                .andExpect(content().string("Willkommen bei der Wetterstation. \n" +
                        "Um alle Wetterdaten anzuzeigen, geben Sie /all ein. \n" +
                        "Um die Wetterdaten für eine bestimmte Stadt anzuzeigen, geben Sie /{city} ein. \n" +
                        "Um neue Wetterdaten hinzuzufügen, geben Sie /add/{city}/{temperature} ein. \n"));
    }

    @Test
    public void testGetAllWeatherData() throws Exception {
        mockMvc.perform(get("/weather/all"))
                .andExpect(status().isOk())
                .andExpect(content().string("[Die aktuelle Temperatur in Wien beträgt 20.0 C° \n" +
                        ", Die aktuelle Temperatur in Graz beträgt 18.0 C° \n" +
                        ", Die aktuelle Temperatur in Linz beträgt 15.0 C° \n" +
                        ", Die aktuelle Temperatur in TestCity beträgt 20.0 C° \n" +
                        "]"));
    }

    @Test
    public void testGetCurrentTemperature() throws Exception {
        mockMvc.perform(get("/weather/{city}", "Wien"))
                .andExpect(status().isOk())
                .andExpect(content().string("[Die aktuelle Temperatur in Wien beträgt 20.0 C° \n" + "]"));
    }

    @Test
    public void testAddNewWeatherData() throws Exception {
        mockMvc.perform(get("/weather/add/{city}/{temperature}", "TestCity", 20.0))
                .andExpect(status().isOk())
                .andExpect(content().string("Die Temperatur in TestCity wurde auf 20.0 C° gesetzt."));
    }
}
