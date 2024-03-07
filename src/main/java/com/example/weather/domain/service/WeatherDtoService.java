package com.example.weather.domain.service;

import com.example.weather.domain.dto.WeatherDto;
import com.example.weather.domain.repository.WeatherDtoRepository;
import com.example.weather.error.WeatherNotFoundException;
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

    public Optional<WeatherDto> getWeatherDtoById(Long idWeatherDto) throws WeatherNotFoundException {

        Optional<WeatherDto> weatherDto = weatherDtoRepository.getWeatherDtoById(idWeatherDto);
        if(!weatherDto.isPresent()){
            throw new WeatherNotFoundException("Record not found.");
        }

        return weatherDto;
    }

    public Optional<List<WeatherDto>> getWeatherDtoEnabled(){
        return weatherDtoRepository.getWeatherDtoEnabled();
    }

    public WeatherDto save(WeatherDto weatherDto){
        return weatherDtoRepository.save(weatherDto);
    }

    public boolean delete(Long idWeatherDto) throws WeatherNotFoundException {
        return getWeatherDtoById(idWeatherDto).map(weatherDto -> {
            weatherDtoRepository.delete(idWeatherDto);
            return true;
        })
        .orElse(false);
    }

}
