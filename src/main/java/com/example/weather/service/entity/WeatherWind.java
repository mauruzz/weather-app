package com.example.weather.service.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
public class WeatherWind {

    private Long id;

    private float speed;
    private float angle;
    private String dir;

    private WeatherDailyDataAllDay weatherDailyDataAllDay;

    private WeatherCurrent weatherCurrent;

}