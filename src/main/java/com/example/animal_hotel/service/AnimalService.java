package com.example.animal_hotel.service;

import com.example.animal_hotel.entity.Animal;
import com.example.animal_hotel.repository.AnimalRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Animal create(Animal animal) {
        animal.setStatus("IN_HOTEL");
        animal.setActualCheckOutDate(null);

        return animalRepository.save(animal);
    }

    public List<Animal> getAll() {
        return animalRepository.findAll();
    }

    public Animal getById(Long id) {
        return animalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Animal not found"));
    }

    public Animal update(Long id, Animal updatedAnimal) {
        Animal animal = getById(id);

        animal.setName(updatedAnimal.getName());
        animal.setSpecies(updatedAnimal.getSpecies());
        animal.setOwnerName(updatedAnimal.getOwnerName());
        animal.setWorkerName(updatedAnimal.getWorkerName());
        animal.setCheckInDate(updatedAnimal.getCheckInDate());
        animal.setPlannedCheckOutDate(updatedAnimal.getPlannedCheckOutDate());

        return animalRepository.save(animal);
    }

    public void delete(Long id) {
        animalRepository.deleteById(id);
    }

    public Animal extendStay(Long id, LocalDate newDate) {
        Animal animal = getById(id);

        if ("HOME".equals(animal.getStatus())) {
            throw new RuntimeException("Animal has already been checked out");
        }

        animal.setPlannedCheckOutDate(newDate);

        return animalRepository.save(animal);
    }

    public Animal checkOut(Long id) {
        Animal animal = getById(id);

        if ("HOME".equals(animal.getStatus())) {
            throw new RuntimeException("Animal has already been checked out");
        }

        animal.setActualCheckOutDate(LocalDate.now());
        animal.setStatus("HOME");

        return animalRepository.save(animal);
    }

    public long getAnimalsInHotelCount() {
        return animalRepository.countByStatus("IN_HOTEL");
    }

    public long getAnimalsHomeCount() {
        return animalRepository.countByStatus("HOME");
    }
}