package com.example.car_management.controller;

import com.example.car_management.dto.CreateGarageDTO;
import com.example.car_management.model.Garage;
import com.example.car_management.service.GarageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/garages")
public class GarageController {

    private final GarageService garageService;

    // Constructor injection for better testability and readability
    @Autowired
    public GarageController(GarageService garageService) {
        this.garageService = garageService;
    }

    // Create a new garage
    @PostMapping
    public ResponseEntity<Garage> createGarage(@Valid @RequestBody CreateGarageDTO garageDto) {
        Garage createdGarage = garageService.createGarage(garageDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdGarage);
    }

    // Retrieve a garage by ID
    @GetMapping("/{id}")
    public ResponseEntity<Garage> getGarageById(@PathVariable Long id) {
        return garageService.getGarageById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Retrieve all garages with optional filters
    @GetMapping
    public ResponseEntity<List<Garage>> getAllGarages(
            @RequestParam(required = false) String city,
            @RequestParam(required = false) Integer capacity) {
        List<Garage> garages = garageService.getGaragesByFilters(city, capacity);
        return ResponseEntity.ok(garages);
    }

    // Update a garage
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateGarage(@PathVariable Long id, @Valid @RequestBody CreateGarageDTO garageDto) {
        return garageService.updateGarage(id, garageDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Delete a garage
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGarage(@PathVariable Long id) {
        boolean isDeleted = garageService.deleteGarage(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
