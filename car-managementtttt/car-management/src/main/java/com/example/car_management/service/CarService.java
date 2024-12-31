package com.example.car_management.service;

import com.example.car_management.model.Car;
import com.example.car_management.repository.CarRepository;
import com.example.car_management.dto.CreateCarDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    // Retrieve the list of all cars
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    // Add a new car
    public Car addCar(CreateCarDTO carDto) {
        Car newCar = new Car();
        // Set the properties of the new car based on the DTO
        newCar.setBrand(carDto.getMake());  // Map make to brand
        newCar.setModel(carDto.getModel());  // Set model
        newCar.setYear(carDto.getProductionYear());  // Set production year
        // Further logic can be added for handling related entities like garageIds
        return carRepository.save(newCar);  // Save the new car to the database
    }

    public Car createCar(CreateCarDTO carDto) {
        return null;
    }
}

