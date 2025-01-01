package com.example.car_management.model;

import jakarta.persistence.*;

@Entity
public class ServiceCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "center_name", nullable = false)  // Explicit column name mapping
    private String name;

    @Column(nullable = false)  // Not nullable field
    private String city;

    @Column(nullable = false)  // Not nullable field
    private int capacity;

    @Column // Nullable field for location (default is true if not specified)
    private String location;

    // Default constructor
    public ServiceCenter() {}

    // Constructor with parameters
    public ServiceCenter(String name, String city, int capacity, String location) {
        this.name = name;
        this.city = city;
        this.capacity = capacity;
        this.location = location;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return String.format("ServiceCenter{id=%d, name='%s', city='%s', capacity=%d, location='%s'}",
                id, name, city, capacity, location);
    }
}


