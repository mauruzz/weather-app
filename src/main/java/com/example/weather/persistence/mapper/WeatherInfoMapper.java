package com.example.weather.persistence.mapper;

import com.example.weather.domain.dto.WeatherDto;
import com.example.weather.service.entity.WeatherInfo;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WeatherInfoMapper {

    //Mapeo clase de WeatherInfo a Weater
    WeatherDto toWeatherDto(WeatherInfo weatherInfo);
    List<WeatherDto> toListWeatherDto(List<WeatherInfo> listWeatherInfo);

    //Mapeo clase de WeatherDto a WeatherInfo
    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "apikey", ignore = true),
            @Mapping(target = "elevation", ignore = true),
            @Mapping(target = "lat", ignore = true),
            @Mapping(target = "lon", ignore = true),
            @Mapping(target = "timeZone", ignore = true),
            @Mapping(target = "daily", ignore = true),
            @Mapping(target = "current", ignore = true)
    })
    WeatherInfo toWeatherInfo(WeatherDto weatherDto);
    List<WeatherInfo> toListWeatherInfo(List<WeatherDto> listWeatherDto);

}
