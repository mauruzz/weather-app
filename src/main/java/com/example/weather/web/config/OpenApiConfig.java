package com.example.weather.web.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "Weather API",
                description = "CRUD operations on data consumed from the meteosource.com API",
                summary = "sumary MODIFICAR!!!!",
                termsOfService = "Educational purposes, feel free to use if its usefull.",
                contact = @Contact(
                        name = "Mauro Axel Tedesco",
                        email = "mauroaxelt@gmail.com"
                ),
                version = "v1.0"
        ),
        servers = {
                @Server(
                        description = "Dev",
                        url = "http://localhost:8090/weather/app"
                )
        }
)
public class OpenApiConfig {
}
