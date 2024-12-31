package com.example.car_management.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateGarageDTO {

    @NotNull(message = "Garage name is required")
    @Size(min = 1, max = 100, message = "Name must be between 1 and 100 characters")
    private String name;

    @NotNull(message = "Location is required")
    @Size(min = 1, max = 100, message = "Location must be between 1 and 100 characters")
    private String location;

    @NotNull(message = "Capacity is required")
    private Integer capacity;

    @NotNull(message = "City is required")
    @Size(min = 1, max = 50, message = "City must be between 1 and 50 characters")
    private String city;

    // Constructors
    public CreateGarageDTO() {}

    public CreateGarageDTO(String name, String location, Integer capacity, String city) {
        this.name = name;
        this.location = location;
        this.capacity = capacity;
        this.city = city;
    }

    // Getter and Setter methods using the latest conventions

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "CreateGarageDTO{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", capacity=" + capacity +
                ", city='" + city + '\'' +
                '}';
    }
}


