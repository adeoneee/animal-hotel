
package com.example.report_service.controller;

import com.example.report_service.entity.Animal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    private final RestTemplate restTemplate;

    public ReportController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/animals")
    public List<Animal> getAnimalsReport() {
        Animal[] animals = restTemplate.getForObject(
                "http://animal-service:8080/api/animals",
                Animal[].class
        );

        return animals == null ? List.of() : Arrays.asList(animals);
    }
}
