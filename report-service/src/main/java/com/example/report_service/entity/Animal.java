package com.example.report_service.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "animals")
public class Animal {

    @Id
    private Long id;

    private String name;

    private String species;

    @Column(name = "owner_name")
    private String ownerName;

    @Column(name = "worker_name")
    private String workerName;

    @Column(name = "check_in_date")
    private LocalDate checkInDate;

    @Column(name = "planned_check_out_date")
    private LocalDate plannedCheckOutDate;

    @Column(name = "actual_check_out_date")
    private LocalDate actualCheckOutDate;

    private String status;

    public Animal() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getWorkerName() {
        return workerName;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getPlannedCheckOutDate() {
        return plannedCheckOutDate;
    }

    public LocalDate getActualCheckOutDate() {
        return actualCheckOutDate;
    }

    public String getStatus() {
        return status;
    }
}