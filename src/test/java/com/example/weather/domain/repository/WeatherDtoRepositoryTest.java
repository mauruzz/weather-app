package com.example.weather.domain.repository;

import com.example.weather.domain.dto.WeatherDto;
import com.example.weather.persistence.entity.Weather;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class WeatherDtoRepositoryTest {
/*
    @Autowired
    WeatherDtoRepository weatherDtoRepository;
    @Autowired
    TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        Weather weather = Weather.builder()
                .id(1L)
                .day("2024-02-21")
                .icon("sunny")
                .summary("Sunny")
                .temperature(BigDecimal.valueOf(28.5))
                .temperature_min(BigDecimal.valueOf(22.5))
                .temperature_max(BigDecimal.valueOf(31.5))
                .type("none")
                .speed(BigDecimal.valueOf(3.8))
                .dir("E")
                .enabled(false)
                .build();
        testEntityManager.persist(weather);
    }

    @Test
    public void getWeatherDtoByIdFound() {

        Optional<WeatherDto> weatherDto = weatherDtoRepository.getWeatherDtoById(1L);
        assertEquals(weatherDto.get().getId(), 1L);

    }

    @Test
    void getWeatherEnabled() {
    }
*/

}