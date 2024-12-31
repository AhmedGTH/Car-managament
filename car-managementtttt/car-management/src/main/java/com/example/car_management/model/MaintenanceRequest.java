package com.example.car_management.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class MaintenanceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "car_id", nullable = false)  // Explicit column name mapping
    private Long carId;

    @Column(name = "service_center_id", nullable = false)  // Explicit column name mapping
    private Long serviceCenterId;

    @Column(name = "request_date", nullable = false)  // Explicit column name mapping
    private LocalDate requestDate;

    @Column(name = "service_type", nullable = false)  // Explicit column name mapping
    private String serviceType;

    // Default constructor
    public MaintenanceRequest() {}

    // Constructor with parameters
    public MaintenanceRequest(Long carId, Long serviceCenterId, LocalDate requestDate, String serviceType) {
        this.carId = carId;
        this.serviceCenterId = serviceCenterId;
        this.requestDate = requestDate;
        this.serviceType = serviceType;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Long getServiceCenterId() {
        return serviceCenterId;
    }

    public void setServiceCenterId(Long serviceCenterId) {
        this.serviceCenterId = serviceCenterId;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    @Override
    public String toString() {
        return "MaintenanceRequest{" +
                "id=" + id +
                ", carId=" + carId +
                ", serviceCenterId=" + serviceCenterId +
                ", requestDate=" + requestDate +
                ", serviceType='" + serviceType + '\'' +
                '}';
    }
}

