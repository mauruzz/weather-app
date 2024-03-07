package com.example.weather.domain.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherDto {


    private Long id;

    private String day;
    private String icon; //nombre del icono
    private String summary; //resumen del tiempo: soleado, lluvioso, etc

    private BigDecimal temperature;
    private BigDecimal temperature_min;
    private BigDecimal temperature_max;

    private String type; //tipo de precipitación

    private BigDecimal speed; //velocidad del viento
    private String dir; //dirección del viento

    private boolean enabled;  //diferencio entre guardados por el usuario y el sistema

}
