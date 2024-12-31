package com.example.car_management.controller;

import com.example.car_management.dto.CreateCarDTO;
import com.example.car_management.dto.ResponseCarDTO;
import com.example.car_management.model.Car;
import com.example.car_management.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    // Constructor injection is preferred over field injection
    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    // Retrieve all cars
    @GetMapping
    public ResponseEntity<List<ResponseCarDTO>> getAllCars() {
        List<ResponseCarDTO> carResponses = carService.getAllCars().stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(carResponses);
    }

    // Add a new car
    @PostMapping
    public ResponseEntity<ResponseCarDTO> createCar(@RequestBody CreateCarDTO carDto) {
        Car createdCar = carService.createCar(carDto);
        ResponseCarDTO responseDto = mapToResponseDto(createdCar);

        return ResponseEntity.status(201).body(responseDto);
    }

    // Private helper method to map Car to ResponseCarDTO
    private ResponseCarDTO mapToResponseDto(Car car) {
        ResponseCarDTO dto = new ResponseCarDTO();
        dto.setId(car.getId());
        dto.setMake(car.getBrand());
        dto.setModel(car.getModel());
        dto.setProductionYear(car.getYear());
        dto.setLicensePlate(car.getLicensePlate());
        return dto;
    }
}

