package com.example.car_management.repository;

import com.example.car_management.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    // Find cars by their brand
    List<Car> findByBrand(String brand);

    // Find cars by brand and production year range
    List<Car> findByBrandAndYearBetween(String brand, Integer startYear, Integer endYear);

    // Optional: Add more query methods based on other requirements
}

