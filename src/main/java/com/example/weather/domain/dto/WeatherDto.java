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
@Builder
@Entity
public class WeatherDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Please insert day.")
    private String day;
    @NotBlank(message = "Please insert icon name.")
    private String icon; //nombre del icono
    @NotBlank(message = "Please insert summary.")
    private String summary; //resumen del tiempo: soleado, lluvioso, etc

    @Digits(message = "Please insert a valid temperature.", integer = 3, fraction = 1)
    private BigDecimal temperature;
    @Digits(message = "Please insert a valid minimum temperature.", integer = 3, fraction = 1)
    private BigDecimal temperature_min;
    @Digits(message = "Please insert a valid maximum temperature.", integer = 3, fraction = 1)
    private BigDecimal temperature_max;

    @NotBlank(message = "Please insert precipitation type.")
    private String type; //tipo de precipitación

    @Digits(message = "Please insert a valid wind speed.", integer = 3, fraction = 1)
    private BigDecimal speed; //velocidad del viento
    @NotBlank(message = "Please insert wind direction.")
    private String dir; //dirección del viento

    @NotNull(message = "Enabled can't be null")
    private boolean enabled;  //diferencio entre guardados por el usuario y el sistema

}
