package com.example.weather.persistence.crud;

import com.example.weather.domain.dto.WeatherDto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WeatherDtoCrudRepository extends CrudRepository<WeatherDto,Long> {

    List<WeatherDto> findByEnabledOrderByIdAsc(Boolean enableTrue);

}
