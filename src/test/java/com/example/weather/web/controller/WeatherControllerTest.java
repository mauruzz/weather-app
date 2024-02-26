package com.example.weather.web.controller;

import com.example.weather.domain.dto.WeatherDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class WeatherControllerTest {



    @BeforeEach
    void setUp() {

        WeatherDto weatherDto = WeatherDto.builder()
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


    }

    @Test
    void getWeatherDtoById() {
    }

    @Test
    void updateEnabled() {
    }
}