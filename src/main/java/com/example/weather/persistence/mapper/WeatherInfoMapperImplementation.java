package com.example.weather.persistence.mapper;

import com.example.weather.domain.dto.WeatherDto;
import com.example.weather.service.entity.WeatherInfo;
import org.mapstruct.Mapper;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public class WeatherInfoMapperImplementation implements WeatherInfoMapper{

    @Override
    public WeatherDto toWeatherDto(WeatherInfo weatherInfo) {

        if (weatherInfo == null) {
            return null;
        }

        WeatherDto.WeatherDtoBuilder weatherDto = WeatherDto.builder();

        weatherDto.id((long) weatherInfo.getId());
        weatherDto.day( weatherInfo.getDaily().getData().get(0).getDay() );
        weatherDto.icon( weatherInfo.getCurrent().getIcon() );
        weatherDto.summary( weatherInfo.getCurrent().getSummary() );
        weatherDto.temperature( BigDecimal.valueOf(weatherInfo.getCurrent().getTemperature()).setScale(1, RoundingMode.HALF_UP ) );
        weatherDto.temperature_min( BigDecimal.valueOf(weatherInfo.getDaily().getData().get(0).getAll_day().getTemperature_min()).setScale(1, RoundingMode.HALF_UP ) );
        weatherDto.temperature_max( BigDecimal.valueOf(weatherInfo.getDaily().getData().get(0).getAll_day().getTemperature_max()).setScale(1, RoundingMode.HALF_UP ) );
        weatherDto.type( weatherInfo.getCurrent().getPrecipitation().getType() );
        weatherDto.speed( BigDecimal.valueOf(weatherInfo.getCurrent().getWind().getSpeed()).setScale(1, RoundingMode.HALF_UP ) );
        weatherDto.dir( weatherInfo.getCurrent().getWind().getDir() );

        return weatherDto.build();
    }

    @Override
    public List<WeatherDto> toListWeatherDto(List<WeatherInfo> listWeatherInfo) {
        if ( listWeatherInfo == null ) {
            return null;
        }

        List<WeatherDto> list = new ArrayList<>( listWeatherInfo.size() );
        for ( WeatherInfo weatherInfo : listWeatherInfo ) {
            list.add( toWeatherDto( weatherInfo ) );
        }

        return list;
    }

    @Override
    public WeatherInfo toWeatherInfo(WeatherDto weatherDto) {
        if (weatherDto == null) {
            return null;
        }

        WeatherInfo weatherInfo = new WeatherInfo();

        weatherInfo.setId( Integer.parseInt( String.valueOf(weatherDto.getId())) );
        weatherInfo.setApikey( null );
        weatherInfo.setCurrent(null);
        weatherInfo.setDaily(null);
        weatherInfo.setElevation(0);
        weatherInfo.setLat(null);
        weatherInfo.setLon(null);

        return weatherInfo;
    }

    @Override
    public List<WeatherInfo> toListWeatherInfo(List<WeatherDto> listWeatherDto) {
        if ( listWeatherDto == null ) {
            return null;
        }

        List<WeatherInfo> list = new ArrayList<>( listWeatherDto.size() );
        for ( WeatherDto weatherDto : listWeatherDto ) {
            list.add( toWeatherInfo( weatherDto ) );
        }

        return list;
    }

}
