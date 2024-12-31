package com.example.car_management.model;

import jakarta.persistence.*;

@Entity
public class Garage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false) // Indicating that the name is mandatory
    private String name;

    @Column(name = "location", nullable = false) // Indicating that location is mandatory
    private String location;

    @Column(name = "city", nullable = false) // Indicating that city is mandatory
    private String city;

    @Column(name = "capacity", nullable = false) // Indicating that capacity is mandatory
    private Integer capacity;

    // Default constructor
    public Garage() {}

    // Constructor with parameters
    public Garage(String name, String location, String city, Integer capacity) {
        this.name = name;
        this.location = location;
        this.city = city;
        this.capacity = capacity;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Garage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", city='" + city + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}

