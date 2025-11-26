package com.codeanapp.project.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI springAppOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("BULK INSERT & QUERY SERVICE")
                        .description("RESTful API For bulk insert and query join")
                        .version("v0.0.1")
                )
                .externalDocs(new ExternalDocumentation()
                        .description("Spring Boot Documentation")
                        .url("https://spring.io/projects/spring-boot")
                );
    }
}
