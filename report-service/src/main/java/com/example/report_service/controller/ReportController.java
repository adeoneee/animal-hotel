package com.example.report_service.controller;

import com.example.report_service.entity.Animal;
import com.example.report_service.repository.AnimalRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    private final AnimalRepository animalRepository;

    public ReportController(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @GetMapping("/animals")
    public List<Animal> getAnimalsReport() {
        return animalRepository.findAll();
    }
}