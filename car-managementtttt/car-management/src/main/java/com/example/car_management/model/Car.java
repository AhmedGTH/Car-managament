package com.example.car_management.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand", nullable = false) // Adding nullable to indicate that brand cannot be null
    private String brand; // Maps to "make" in the DTO

    @Column(name = "model", nullable = false) // Adding nullable to indicate that model cannot be null
    private String model;

    @Column(name = "`year`", nullable = false) // Use backticks if "year" is a reserved keyword
    private int year; // Maps to "productionYear" in the DTO

    @Column(name = "license_plate", nullable = false) // Ensures license plate cannot be null
    private String licensePlate;

    // Default constructor
    public Car() {}

    // Constructor with parameters
    public Car(String brand, String model, int year, String licensePlate) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.licensePlate = licensePlate;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", licensePlate='" + licensePlate + '\'' +
                '}';
    }
}

