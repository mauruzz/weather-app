package com.example.weather.service.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
public class WeatherDailyData {

    private Long id;

    private String day;
    private String weather;
    private int icon;
    private String summary;

    private WeatherDailyDataAllDay all_day;

    private WeatherDaily weatherDaily;

}
