package com.example.car_management.service;

import com.example.car_management.dto.CreateGarageDTO;
import com.example.car_management.model.Garage;
import com.example.car_management.repository.GarageRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GarageService {

    @Autowired
    private GarageRepository garageRepository;

    // Add a new garage to the system
    public Garage addGarage(CreateGarageDTO garageDto) {
        Garage newGarage = new Garage();
        newGarage.setName(garageDto.getName());
        newGarage.setLocation(garageDto.getLocation());
        newGarage.setCity(garageDto.getCity());
        newGarage.setCapacity(garageDto.getCapacity());
        return garageRepository.save(newGarage);  // Save the new garage
    }

    // Retrieve garage by its ID
    public Optional<Garage> getGarageById(Long id) {
        return garageRepository.findById(id);  // Fetch garage from repository
    }

    // Get all garages with optional filtering by city and capacity
    public List<Garage> getGarages(String city, Integer capacity) {
        if (city != null && capacity != null) {
            return garageRepository.findByCityAndCapacity(city, capacity);
        } else if (city != null) {
            return garageRepository.findByCity(city);
        } else if (capacity != null) {
            return garageRepository.findByCapacity(capacity);
        } else {
            return garageRepository.findAll();  // Return all if no filters provided
        }
    }

    // Update an existing garage details
    public Optional<Garage> modifyGarage(Long id, CreateGarageDTO garageDto) {
        Optional<Garage> existingGarage = garageRepository.findById(id);
        if (existingGarage.isPresent()) {
            Garage garage = existingGarage.get();
            garage.setName(garageDto.getName());
            garage.setLocation(garageDto.getLocation());
            garage.setCity(garageDto.getCity());
            garage.setCapacity(garageDto.getCapacity());
            return Optional.of(garageRepository.save(garage));  // Save the updated garage
        }
        return Optional.empty();  // Return empty if garage not found
    }

    // Remove a garage from the system
    public boolean removeGarage(Long id) {
        if (garageRepository.existsById(id)) {
            garageRepository.deleteById(id);  // Delete the garage by its ID
            return true;  // Return true if deletion was successful
        }
        return false;  // Return false if garage with the given ID doesn't exist
    }

    public Garage createGarage(@Valid CreateGarageDTO garageDto) {
        return null;
    }

    public List<Garage> getGaragesByFilters(String city, Integer capacity) {
        return List.of();
    }

    public Optional<Object> updateGarage(Long id, @Valid CreateGarageDTO garageDto) {
        return Optional.empty();
    }

    public boolean deleteGarage(Long id) {
        return false;
    }
}

