package com.example.weather.service.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
public class WeatherDaily {

    private Long id;

    private List<WeatherDailyData> data;

    private WeatherInfo weatherInfo;

}
