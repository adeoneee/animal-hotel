
package com.example.report_service.controller;

import com.example.report_service.entity.Animal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportController {
    private static final Logger log = LoggerFactory.getLogger(ReportController.class);
    private final RestTemplate restTemplate;

    public ReportController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/animals")
    public List<Animal> getAnimalsReport() {
        log.info("TRACE_CHECK traceId={} spanId={}", MDC.get("traceId"), MDC.get("spanId"));
        Animal[] animals = restTemplate.getForObject(
                "http://animal-service:8080/api/animals",
                Animal[].class
        );

        return animals == null ? List.of() : Arrays.asList(animals);
    }
}
