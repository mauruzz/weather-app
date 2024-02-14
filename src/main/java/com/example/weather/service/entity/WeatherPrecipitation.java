package com.example.weather.service.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
public class WeatherPrecipitation {

    private Long id;

    private float total;
    private String type;

    private WeatherDailyDataAllDay weatherDailyDataAllDay;

    private WeatherCurrent weatherCurrent;

}
