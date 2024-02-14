package com.example.weather.service;

import com.example.weather.service.entity.WeatherInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class WeatherInfoServiceImpl{

    final String X_API_KEY_VALUE = "bpslqmqnuzfp42rlxd2b8glkc50ap7tlfkvjfa1g ";
    final String PLACE_ID = "ciudad-autonoma-de-buenos-aires";
    final String SECTIONS = "all";
    final String TIMEZONE = "UTC";
    final String LANGUAJE = "en";
    final String UNITS = "metric";

    private final RestTemplate restTemplate;

    public WeatherInfo getWeatherInfo() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("X-API-Key", X_API_KEY_VALUE);
        ResponseEntity<WeatherInfo> response = restTemplate.exchange(
                "https://www.meteosource.com/api/v1/free/point?place_id="+PLACE_ID+"&sections="+SECTIONS+"&timezone="+TIMEZONE+"&language="+LANGUAJE+"&units="+UNITS,
                HttpMethod.GET,
                new HttpEntity<>(headers),
                WeatherInfo.class
        );

        return response.getBody();
    }

}
