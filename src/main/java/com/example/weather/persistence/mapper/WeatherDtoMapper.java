package com.example.weather.persistence.mapper;

import com.example.weather.domain.dto.WeatherDto;
import com.example.weather.persistence.entity.Weather;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WeatherDtoMapper {

    //Mapeo clase de Weather a WeatherDto
    WeatherDto toWeatherDto(Weather weather);
    List<WeatherDto> toListWeatherDto(List<Weather> listWeather);

    //Mapeo clase de WeatherDto a Weather
    @InheritInverseConfiguration
    Weather toWeather(WeatherDto weatherDto);
    List<Weather> toListWeather(List<WeatherDto> listWeatherDto);

}
