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


		//ResponseEntity<WeatherInfo> weatherInfo1 = new WeatherInfoServiceImpl()
		/*
		WeatherInfo weatherInfo;
		try {
			weatherInfo = WeatherInfoServiceImpl.;
		} catch (IOException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}

		System.out.println("el tiempo es " + weatherInfo.toString());
		System.out.println(weatherInfo.getDaily().getData().get(0).toString());
		System.out.println();

		System.out.println("Muestro datos para guardar, los que interesan");
		System.out.println();

		String sDate = weatherInfo.getDaily().getData().get(0).getDay();
		SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
		Date date = formatter1.parse(sDate);
		System.out.println("Fecha: " + date);

		System.out.println("Imagen clima: " + weatherInfo.getCurrent().getIcon());
		System.out.println("Clima: " + weatherInfo.getCurrent().getSummary());
		System.out.println("Temperatura: " + weatherInfo.getCurrent().getTemperature());
		System.out.println("Max/Min: " + weatherInfo.getDaily().getData().get(0).getAll_day().getTemperature_max()
				+ "/" + weatherInfo.getDaily().getData().get(0).getAll_day().getTemperature_min());
		System.out.println("Lluvia: " + weatherInfo.getCurrent().getPrecipitation().getType());
		System.out.println("Viento: " + weatherInfo.getCurrent().getWind().getSpeed());
		System.out.println();

		System.out.println();
		System.out.println("AHORA LOS IMPRIMO DESDE EL DTO");
		System.out.println();

		WeatherInfoMapperImplementation mapper = new WeatherInfoMapperImplementation();
		WeatherDto weatherDto = mapper.toWeatherDto(weatherInfo);


		String sDate1 = weatherDto.getDay();
		SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = formatter2.parse(sDate1);
		System.out.println("Fecha: " + date1);

		System.out.println("Imagen clima: " + weatherDto.getIcon());
		System.out.println("Clima: " + weatherDto.getSummary());
		System.out.println("Temperatura: " + weatherDto.getTemperature());
		System.out.println("Max/Min: " + weatherDto.getTemperature_max()
				+ "/" + weatherDto.getTemperature_min());
		System.out.println("Lluvia: " + weatherDto.getType());
		System.out.println("Viento: " + weatherDto.getSpeed());
		System.out.println();

*/
	}

}
