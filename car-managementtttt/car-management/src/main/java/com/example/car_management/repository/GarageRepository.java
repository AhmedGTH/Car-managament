package com.example.car_management.repository;

import com.example.car_management.model.Garage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GarageRepository extends JpaRepository<Garage, Long> {

    // Find garages by their city
    List<Garage> findByCity(String city);

    // Find garages by their capacity
    List<Garage> findByCapacity(Integer capacity);

    // Find garages by both city and capacity
    List<Garage> findByCityAndCapacity(String city, Integer capacity);

    // Optional: Add additional query methods based on other criteria
}
