package com.example.weather.service.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
public class WeatherDailyDataAllDay {

    private Long id;

    private String weather;
    private float temperature_min;
    private float temperature_max;

    private WeatherWind wind;

    private WeatherPrecipitation precipitation;

    private WeatherDailyData weatherDailyData;

}
