package com.example.weather.domain.repository;

import com.example.weather.domain.dto.WeatherDto;
import com.example.weather.persistence.crud.WeatherDtoCrudRepository;
import com.example.weather.service.entity.WeatherInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class WeatherDtoRepository{

    @Autowired
    private WeatherDtoCrudRepository weatherDtoCrudRepository;

    public Optional<WeatherDto> getWeatherDtoById(Long idWeatherDto){
        return weatherDtoCrudRepository.findById(idWeatherDto);
    }

    //Optional<WeatherDto> getNewWeatherDto();

    public List<WeatherDto> getAll(){
        return (List<WeatherDto>)weatherDtoCrudRepository.findAll();
    }

    public Optional<List<WeatherDto>> getWeatherEnabled(){
        List<WeatherDto> listWeatherDto = weatherDtoCrudRepository.findByEnabledOrderByIdAsc(true);
        return Optional.of(listWeatherDto);
    }

    public WeatherDto save(WeatherDto weatherDto){
        return weatherDtoCrudRepository.save(weatherDto);
    }

    public void delete(Long idWeatherDto){
        weatherDtoCrudRepository.deleteById(idWeatherDto);
    }

}
