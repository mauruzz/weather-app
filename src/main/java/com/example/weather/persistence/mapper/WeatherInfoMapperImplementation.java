package com.example.weather.persistence.mapper;

import com.example.weather.domain.dto.WeatherDto;
import com.example.weather.service.entity.WeatherInfo;
import org.mapstruct.Mapper;

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

        weatherDto.id( weatherInfo.getId() );
        weatherDto.day( weatherInfo.getDaily().getData().get(0).getDay() );
        weatherDto.icon( weatherInfo.getCurrent().getIcon() );
        weatherDto.summary( weatherInfo.getCurrent().getSummary() );
        weatherDto.temperature( weatherInfo.getCurrent().getTemperature() );
        weatherDto.temperature_min( weatherInfo.getDaily().getData().get(0).getAll_day().getTemperature_min() );
        weatherDto.temperature_max( weatherInfo.getDaily().getData().get(0).getAll_day().getTemperature_max() );
        weatherDto.type( weatherInfo.getCurrent().getPrecipitation().getType() );
        weatherDto.speed( weatherInfo.getCurrent().getWind().getSpeed() );
        weatherDto.dir( weatherInfo.getCurrent().getWind().getDir() );

        return weatherDto.build();
    }

    @Override
    public List<WeatherDto> toListWeatherDto(List<WeatherInfo> listWeatherInfo) {
        if ( listWeatherInfo == null ) {
            return null;
        }

        List<WeatherDto> list = new ArrayList<WeatherDto>( listWeatherInfo.size() );
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

        weatherInfo.setId( weatherDto.getId() );
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

        List<WeatherInfo> list = new ArrayList<WeatherInfo>( listWeatherDto.size() );
        for ( WeatherDto weatherDto : listWeatherDto ) {
            list.add( toWeatherInfo( weatherDto ) );
        }

        return list;
    }

}
