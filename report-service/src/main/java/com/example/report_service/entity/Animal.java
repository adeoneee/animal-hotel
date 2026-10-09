
package com.example.report_service.entity;

import java.time.LocalDate;

public class Animal {

    private Long id;
    private String name;
    private String species;
    private String ownerName;
    private String workerName;
    private LocalDate checkInDate;
    private LocalDate plannedCheckOutDate;
    private LocalDate actualCheckOutDate;
    private String status;

    public Animal() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getPlannedCheckOutDate() {
        return plannedCheckOutDate;
    }

    public void setPlannedCheckOutDate(LocalDate plannedCheckOutDate) {
        this.plannedCheckOutDate = plannedCheckOutDate;
    }

    public LocalDate getActualCheckOutDate() {
        return actualCheckOutDate;
    }

    public void setActualCheckOutDate(LocalDate actualCheckOutDate) {
        this.actualCheckOutDate = actualCheckOutDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
