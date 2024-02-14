package com.example.weather.domain.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class WeatherDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String day;
    private String icon; //nombre del icono
    private String summary; //resumen del tiempo: soleado, lluvioso, etc

    private float temperature;
    private float temperature_min;
    private float temperature_max;

    private String type; //tipo de precipitación

    private float speed; //velocidad del viento
    private String dir; //dirección del viento

    private boolean enabled;  //diferencio entre guardados por el usuario y el sistema

}
