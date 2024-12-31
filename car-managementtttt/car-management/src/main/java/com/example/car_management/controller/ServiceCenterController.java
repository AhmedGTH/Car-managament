package com.example.car_management.controller;

import com.example.car_management.dto.CreateGarageDTO;
import com.example.car_management.dto.UpdateGarageDTO;
import com.example.car_management.model.ServiceCenter;
import com.example.car_management.service.ServiceCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/service-centers")
public class ServiceCenterController {

    private final ServiceCenterService serviceCenterService;

    // Constructor injection for better testability
    @Autowired
    public ServiceCenterController(ServiceCenterService serviceCenterService) {
        this.serviceCenterService = serviceCenterService;
    }

    // Create a new service center
    @PostMapping
    public ResponseEntity<ServiceCenter> createServiceCenter(@Valid @RequestBody CreateGarageDTO createGarageDTO) {
        ServiceCenter createdServiceCenter = serviceCenterService.createServiceCenter(createGarageDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdServiceCenter);
    }

    // Retrieve a service center by ID
    @GetMapping("/{id}")
    public ResponseEntity<ServiceCenter> getServiceCenterById(@PathVariable Long id) {
        return serviceCenterService.getServiceCenterById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Retrieve all service centers, optionally filtered by city
    @GetMapping
    public ResponseEntity<List<ServiceCenter>> getAllServiceCenters(@RequestParam(required = false) String city) {
        List<ServiceCenter> serviceCenters = serviceCenterService.getServiceCentersByCity(city);
        return ResponseEntity.ok(serviceCenters);
    }

    // Update an existing service center
    @PutMapping("/{id}")
    public ResponseEntity<ServiceCenter> updateServiceCenter(
            @PathVariable Long id,
            @Valid @RequestBody UpdateGarageDTO updateGarageDTO) {
        return serviceCenterService.updateServiceCenter(id, updateGarageDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Delete a service center by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServiceCenter(@PathVariable Long id) {
        boolean isDeleted = serviceCenterService.deleteServiceCenter(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}

