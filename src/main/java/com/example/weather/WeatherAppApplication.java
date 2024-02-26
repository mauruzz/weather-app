package com.example.weather;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;

@SpringBootApplication
public class WeatherAppApplication {

	public static void main(String[] args) throws ParseException {
		SpringApplication.run(WeatherAppApplication.class, args);

		System.out.println("pido los datos del clima");
		System.out.println();

	}

}
