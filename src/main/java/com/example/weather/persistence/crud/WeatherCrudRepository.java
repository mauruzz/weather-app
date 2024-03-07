package com.example.weather.persistence.crud;

import com.example.weather.persistence.entity.Weather;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WeatherCrudRepository extends CrudRepository<Weather,Long> {

    List<Weather> findByEnabledOrderByIdAsc(Boolean enableTrue);

}
