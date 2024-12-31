package com.example.car_management.repository;

import com.example.car_management.model.ServiceCenter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceCenterRepository extends JpaRepository<ServiceCenter, Long> {

    // Find all service centers located in a specific city
    List<ServiceCenter> findAllByCity(String city);

    List<ServiceCenter> findByCity(String city);
}

