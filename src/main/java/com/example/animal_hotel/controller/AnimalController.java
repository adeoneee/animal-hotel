package com.example.animal_hotel.controller;

import com.example.animal_hotel.entity.Animal;
import com.example.animal_hotel.service.AnimalService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/animals")
public class AnimalController {

    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @PostMapping
    public Animal create(@RequestBody Animal animal) {
        return animalService.create(animal);
    }

    @GetMapping
    public List<Animal> getAll() {
        return animalService.getAll();
    }

    @GetMapping("/report")
    public Map<String, Long> getReport() {
        return Map.of(
                "animalsInHotel", animalService.getAnimalsInHotelCount(),
                "animalsSentHome", animalService.getAnimalsHomeCount()
        );
    }

    @GetMapping("/{id}")
    public Animal getById(@PathVariable Long id) {
        return animalService.getById(id);
    }

    @PutMapping("/{id}")
    public Animal update(
            @PathVariable Long id,
            @RequestBody Animal animal
    ) {
        return animalService.update(id, animal);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        animalService.delete(id);
    }

    @PatchMapping("/{id}/extend")
    public Animal extendStay(
            @PathVariable Long id,
            @RequestParam LocalDate newDate
    ) {
        return animalService.extendStay(id, newDate);
    }

    @PatchMapping("/{id}/checkout")
    public Animal checkOut(@PathVariable Long id) {
        return animalService.checkOut(id);
    }


}