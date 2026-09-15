package com.example.animal_hotel.repository;

import com.example.animal_hotel.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

    long countByStatus(String status);
}