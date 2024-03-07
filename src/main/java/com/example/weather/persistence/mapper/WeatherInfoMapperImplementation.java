package com.example.weather.persistence.mapper;

import com.example.weather.domain.dto.WeatherDto;
import com.example.weather.persistence.entity.Weather;
import com.example.weather.service.entity.WeatherInfo;
import org.mapstruct.Mapper;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public class WeatherInfoMapperImplementation implements WeatherInfoMapper{

    @Override
    public Weather toWeather(WeatherInfo weatherInfo) {

        if (weatherInfo == null) {
            return null;
        }

        Weather.WeatherBuilder weather = Weather.builder();

        weather.id((long) weatherInfo.getId());
        weather.day( weatherInfo.getDaily().getData().get(0).getDay() );
        weather.icon( weatherInfo.getCurrent().getIcon() );
        weather.summary( weatherInfo.getCurrent().getSummary() );
        weather.temperature( BigDecimal.valueOf(weatherInfo.getCurrent().getTemperature()).setScale(1, RoundingMode.HALF_UP ) );
        weather.temperature_min( BigDecimal.valueOf(weatherInfo.getDaily().getData().get(0).getAll_day().getTemperature_min()).setScale(1, RoundingMode.HALF_UP ) );
        weather.temperature_max( BigDecimal.valueOf(weatherInfo.getDaily().getData().get(0).getAll_day().getTemperature_max()).setScale(1, RoundingMode.HALF_UP ) );
        weather.type( weatherInfo.getCurrent().getPrecipitation().getType() );
        weather.speed( BigDecimal.valueOf(weatherInfo.getCurrent().getWind().getSpeed()).setScale(1, RoundingMode.HALF_UP ) );
        weather.dir( weatherInfo.getCurrent().getWind().getDir() );

        return weather.build();
    }

    @Override
    public List<Weather> toListWeather(List<WeatherInfo> listWeatherInfo) {
        if ( listWeatherInfo == null ) {
            return null;
        }

        List<Weather> list = new ArrayList<>( listWeatherInfo.size() );
        for ( WeatherInfo weatherInfo : listWeatherInfo ) {
            list.add( toWeather( weatherInfo ) );
        }

        return list;
    }

    @Override
    public WeatherInfo toWeatherInfo(Weather weather) {
        if (weather == null) {
            return null;
        }

        WeatherInfo weatherInfo = new WeatherInfo();

        weatherInfo.setId( Integer.parseInt( String.valueOf(weather.getId())) );
        weatherInfo.setApikey( null );
        weatherInfo.setCurrent(null);
        weatherInfo.setDaily(null);
        weatherInfo.setElevation(0);
        weatherInfo.setLat(null);
        weatherInfo.setLon(null);

        return weatherInfo;
    }

    @Override
    public List<WeatherInfo> toListWeatherInfo(List<Weather> listWeather) {
        if ( listWeather == null ) {
            return null;
        }

        List<WeatherInfo> list = new ArrayList<>( listWeather.size() );
        for ( Weather weather : listWeather ) {
            list.add( toWeatherInfo( weather ) );
        }

        return list;
    }

}
