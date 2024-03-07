package com.example.weather.persistence.repository;

import com.example.weather.domain.dto.WeatherDto;
import com.example.weather.domain.repository.WeatherDtoRepository;
import com.example.weather.persistence.crud.WeatherCrudRepository;
import com.example.weather.persistence.entity.Weather;
import com.example.weather.persistence.mapper.WeatherDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class WeatherRepository implements WeatherDtoRepository{

    @Autowired
    private WeatherCrudRepository weatherCrudRepository;

    @Autowired
    private WeatherDtoMapper mapper;

    @Override
    public Optional<WeatherDto> getWeatherDtoById(Long idWeatherDto) {
        return weatherCrudRepository.findById(idWeatherDto).map(weather -> mapper.toWeatherDto(weather));
    }

    public List<WeatherDto> getAll(){
        return  mapper.toListWeatherDto((List<Weather>) weatherCrudRepository.findAll());
    }

    @Override
    public Optional<List<WeatherDto>> getWeatherDtoEnabled(){
        List<Weather> listWeather = weatherCrudRepository.findByEnabledOrderByIdAsc(true);
        return Optional.of(mapper.toListWeatherDto(listWeather));
    }

    @Override
    public WeatherDto save(WeatherDto weatherDto) {
        Weather weather = mapper.toWeather(weatherDto);
        return mapper.toWeatherDto(weatherCrudRepository.save(weather));
    }

    public void delete(Long idWeatherDto){
        weatherCrudRepository.deleteById(idWeatherDto);
    }

}
