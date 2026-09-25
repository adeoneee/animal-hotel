package com.example.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()

                .route("animal-service", route -> route
                        .path("/api/animals/**")
                        .uri("http://localhost:8080"))

                .route("report-service", route -> route
                        .path("/api/reports/**")
                        .uri("http://localhost:8081"))

                .build();
    }
}