package com.example.weather.error;

public class WeatherNotFoundException extends Exception{

    public WeatherNotFoundException(String message) {
        super(message);
    }

}
