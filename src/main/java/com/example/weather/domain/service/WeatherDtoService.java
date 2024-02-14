package com.example.weather.domain.service;

import com.example.weather.domain.dto.WeatherDto;
import com.example.weather.domain.repository.WeatherDtoRepository;
import com.example.weather.persistence.repository.WeatherDtoRepositoryImpl;
import com.example.weather.service.entity.WeatherInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WeatherDtoService {

    @Autowired
    private WeatherDtoRepository weatherDtoRepository;

    public List<WeatherDto> getAll(){
        return weatherDtoRepository.getAll();
    }

    public Optional<WeatherDto> getWeatherDtoById(Long idWeatherDto){
        return weatherDtoRepository.getWeatherDtoById(idWeatherDto);
    }

    public Optional<List<WeatherDto>> getWeatherEnabled(){
        return weatherDtoRepository.getWeatherEnabled();
    }

    public WeatherDto save(WeatherDto weatherDto){
        return weatherDtoRepository.save(weatherDto);
    }

    public boolean delete(Long idWeatherDto){
        return getWeatherDtoById(idWeatherDto).map(weatherDto -> {
            weatherDtoRepository.delete(idWeatherDto);
            return true;
        })
        .orElse(false);
    }

}
