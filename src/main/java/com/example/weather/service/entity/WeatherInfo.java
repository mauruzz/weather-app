package com.example.weather.service.entity;

import jakarta.persistence.*;
import lombok.Data;
//import javax.persistence.*;


@Data
public class WeatherInfo {

    private int id;

    private String apikey = "bpslqmqnuzfp42rlxd2b8glkc50ap7tlfkvjfa1g";
    private String lat;
    private String lon;
    private float elevation;
    private String timeZone;

    private WeatherCurrent current;

    private WeatherDaily daily;


}
