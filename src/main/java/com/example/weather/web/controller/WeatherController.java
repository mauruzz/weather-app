package com.example.weather.web.controller;

import com.example.weather.domain.dto.WeatherDto;
import com.example.weather.domain.service.WeatherDtoService;
import com.example.weather.error.WeatherNotFoundException;
import com.example.weather.persistence.mapper.WeatherInfoMapperImplementation;
import com.example.weather.service.entity.WeatherInfo;
import com.example.weather.service.WeatherInfoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherDtoService weatherDtoService;
    @Autowired
    private WeatherInfoServiceImpl weatherInfoServiceImpl;
    @Autowired
    private WeatherInfoMapperImplementation mapper;

    @Operation(
            tags = "Weather",
            summary = "Gets new weather",
            description = "Consume meteosource.com API and saves only interest info as disabled.",
            responses = {
                    @ApiResponse(
                            description = "Created, record saved as disabled.",
                            responseCode = "201",
                            content = {
                                    @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = WeatherDto.class))
                            }
                    )
            }
    )
    @GetMapping("/new")
    public ResponseEntity<WeatherDto> getWeatherInfo() {
        ResponseEntity<WeatherInfo> weatherInfo = new ResponseEntity<>(weatherInfoServiceImpl.getWeatherInfo(), HttpStatus.OK);
        return new ResponseEntity<>(weatherDtoService.save(mapper.toWeatherDto(weatherInfo.getBody())), HttpStatus.CREATED);
    }

    @Operation(
            tags = "Weather",
            summary = "Gets all",
            description = "Gets all records in the database indiscriminately.",
            responses = {
                    @ApiResponse(
                            description = "Success, records found.",
                            responseCode = "200",
                            content = {
                                    @Content(mediaType = "application/json",
                                            schema = @Schema(implementation = WeatherDto.class))
                            }
                    )
            }
    )
    @GetMapping("/all")
    public ResponseEntity<List<WeatherDto>> getAll(){
        return new ResponseEntity<>(weatherDtoService.getAll(), HttpStatus.OK);
    }

    @Operation(
            tags = "Weather",
            summary = "Gets by id",
            description = "Gets a record by ID send as PathVariable.",
            responses = {
                    @ApiResponse(
                            description = "Success, record found.",
                            responseCode = "200",
                            content = {
                                    @Content(mediaType = "application/json",
                                            schema = @Schema(implementation = WeatherDto.class))
                            }
                    ),
                    @ApiResponse(
                            description = "Not found, record not found.",
                            responseCode = "404",
                            content = @Content
                    )
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<WeatherDto> getWeatherDtoById(
            @Parameter(description = "Id of record to be searched")
            @PathVariable("id") Long idWeatherDto) throws WeatherNotFoundException {
        return weatherDtoService.getWeatherDtoById(idWeatherDto)
                .map(weatherDto -> new ResponseEntity<>(weatherDto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(
            tags = "Weather",
            summary = "Gets enabled",
            description = "Gets all records enabled.",
            responses = {
                    @ApiResponse(
                            description = "Success, records found.",
                            responseCode = "200",
                            content = {
                                    @Content(mediaType = "application/json",
                                            schema = @Schema(implementation = WeatherDto.class))
                            }
                    ),
                    @ApiResponse(
                            description = "Not found, there´s no record enabled.",
                            responseCode = "404",
                            content = @Content
                    )
            }
    )
    @GetMapping("/enabled")
    public ResponseEntity<List<WeatherDto>> getWeatherEnabled(){
        return weatherDtoService.getWeatherEnabled()
                .map(listWeatherDto -> new ResponseEntity<>(listWeatherDto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(
            tags = "Weather",
            summary = "Saves record",
            description = "Saves record submitted in RequestBody.",
            responses = {
                    @ApiResponse(
                            description = "Success, record save.",
                            responseCode = "201",
                            content = {
                                    @Content(mediaType = "application/json",
                                            schema = @Schema(implementation = WeatherDto.class))
                            }
                    )
            }
    )
    @PostMapping("/save")
    public ResponseEntity<WeatherDto> save(@Valid @RequestBody WeatherDto weatherDto){
        return new ResponseEntity<>(weatherDtoService.save(weatherDto), HttpStatus.CREATED);
    }

    @Operation(
            tags = "Weather",
            summary = "Change enabled field",
            description = "Change enabled field of the submitted record in RequestBody.",
            responses = {
                    @ApiResponse(
                            description = "Success, enabled field updated.",
                            responseCode = "200",
                            content = {
                                    @Content(mediaType = "application/json",
                                            schema = @Schema(implementation = WeatherDto.class))
                            }
                    )
            }
    )
    @PutMapping("/update-enabled")
    public ResponseEntity<WeatherDto> updateEnabled(@RequestBody WeatherDto weatherDto){
        weatherDto.setEnabled(!weatherDto.isEnabled());
        return new ResponseEntity<>(weatherDtoService.save(weatherDto), HttpStatus.OK);
    }

    @Operation(
            tags = "Weather",
            summary = "Updates record",
            description = "Updates record submitted in RequestBody.",
            responses = {
                    @ApiResponse(
                            description = "Success, record updated.",
                            responseCode = "200",
                            content = {
                                    @Content(mediaType = "application/json",
                                            schema = @Schema(implementation = WeatherDto.class))
                            }
                    )
            }
    )
    @PutMapping("/update")
    public ResponseEntity<WeatherDto> update(@RequestBody WeatherDto weatherDto){
        return new ResponseEntity<>(weatherDtoService.save(weatherDto), HttpStatus.OK);
    }

    @Operation(
            tags = "Weather",
            summary = "Deletes record",
            description = "Deletes record by ID submitted in PathVarible.",
            responses = {
                    @ApiResponse(
                            description = "Success, record deleted.",
                            responseCode = "200",
                            content = {
                                    @Content(mediaType = "application/json",
                                            schema = @Schema(implementation = WeatherDto.class))
                            }
                    ),
                    @ApiResponse(
                            description = "Not found, there´s no record whit that ID.",
                            responseCode = "404",
                            content = @Content
                    )
            }
    )
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(
            @Parameter(description = "Id of record to be deleted")
            @PathVariable("id") Long idWeatherDto) throws WeatherNotFoundException {
        return (weatherDtoService.delete(idWeatherDto))? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
