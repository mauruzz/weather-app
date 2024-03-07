package com.example.weather.domain.repository;

import com.example.weather.domain.dto.WeatherDto;

import java.util.List;
import java.util.Optional;

public interface WeatherDtoRepository{

    Optional<WeatherDto> getWeatherDtoById(Long idWeatherDto);

    List<WeatherDto> getAll();

    Optional<List<WeatherDto>> getWeatherDtoEnabled();

    WeatherDto save(WeatherDto weatherDto);

    void delete(Long idWeatherDto);

}
