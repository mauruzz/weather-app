package com.example.weather.service.entity;

import jakarta.persistence.*;
import lombok.Data;
import jakarta.persistence.JoinColumn;
@Data
public class WeatherCurrent {

    private Long id;
    private String icon;
    private String summary;
    private float temperature;

    private WeatherWind wind;

    private WeatherPrecipitation precipitation;
    private float cloud_cover;

    private WeatherInfo weatherInfo;


}
