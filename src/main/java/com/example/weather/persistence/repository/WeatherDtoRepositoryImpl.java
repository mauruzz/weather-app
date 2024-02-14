package com.example.weather.persistence.repository;

import com.example.weather.domain.dto.WeatherDto;
import com.example.weather.domain.repository.WeatherDtoRepository;
import com.example.weather.persistence.mapper.WeatherInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public class WeatherDtoRepositoryImpl /*implements WeatherDtoRepository*/ {

    //@Autowired
    //private WeatherInfoCrudRepository weatherInfoCrudRepository;
    @Autowired
    private WeatherInfoMapper mapper;
    //@Autowired
    //private WeatherDtoRepository weatherDtoRepository;
    /*

    @Override
    public Optional<WeatherDto> getWeatherDtoById(Long idWeatherDto) {
        return weatherInfoCrudRepository.findById(idWeatherDto).map(weatherInfo -> mapper.toWeatherDto(weatherInfo));
    }

    @Override
    public List<WeatherDto> getAll() {
        List<WeatherInfo> listWeatherInfo = (List<WeatherInfo>) weatherInfoCrudRepository.findAll();
        return mapper.toListWeatherDto(listWeatherInfo);
    }

    @Override
    public Optional<List<WeatherDto>> getWeatherEnabled() {
        List<WeatherInfo> listWeatherInfo = weatherInfoCrudRepository.findByEnabledOrderByIdDesc(true);
        return Optional.of(mapper.toListWeatherDto(listWeatherInfo));
    }

    @Override
    public WeatherDto save(WeatherDto weatherDto) {
        WeatherInfo weatherInfo = mapper.toWeatherInfo(weatherDto);
        return mapper.toWeatherDto(weatherInfoCrudRepository.save(weatherInfo));
    }

    public WeatherInfo saveWeatherInfo(WeatherInfo weatherInfo) {
        return weatherInfoCrudRepository.save(weatherInfo);
    }

    @Override
    public void delete(Long idWeatherDto){
        weatherInfoCrudRepository.deleteById(idWeatherDto);
    }
*/


/*
    @Override
    public <S extends WeatherDto> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<WeatherDto> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<WeatherDto> findAll() {
        return null;
    }

    @Override
    public Iterable<WeatherDto> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(WeatherDto entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends WeatherDto> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Optional<WeatherDto> getWeatherDtoById(Long idWeatherDto) {
        return Optional.empty();
    }

    @Override
    public List<WeatherDto> getAll() {
        return weatherDtoRepository.getAll();
    }

    @Override
    public Optional<List<WeatherDto>> getWeatherEnabled() {
        return Optional.empty();
    }

    @Override
    public WeatherDto save(WeatherDto weatherDto) {
        //WeatherInfo weatherInfo = mapper.toWeatherInfo(weatherDto);
        //return mapper.toWeatherDto(weatherInfoCrudRepository.save(weatherInfo));
        return weatherDtoRepository.save(weatherDto);
    }

    */
    /*@Override
    public WeatherDto saveWeatherDto(WeatherDto weatherDto){
        return weatherDtoRepository.save(weatherDto);
    }*/

    /*@Override
    public void delete(Long idWeatherDto) {

    }*/
}
