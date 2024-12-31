package com.example.car_management.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CreateMaintenanceDTO {

    @NotNull(message = "Car ID is required")
    private Long carId;

    @NotNull(message = "Service type is required")
    @Size(min = 1, max = 50, message = "Service type must be between 1 and 50 characters")
    private String serviceType;

    @NotNull(message = "Scheduled date is required")
    private String scheduledDate; // This will be passed as a String from the frontend

    @NotNull(message = "Garage ID is required")
    private Long garageId;

    // Constructors
    public CreateMaintenanceDTO() {}

    public CreateMaintenanceDTO(Long carId, String serviceType, String scheduledDate, Long garageId) {
        this.carId = carId;
        this.serviceType = serviceType;
        this.scheduledDate = scheduledDate;
        this.garageId = garageId;
    }

    // Getter and Setter methods using the latest conventions

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(String scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public Long getGarageId() {
        return garageId;
    }

    public void setGarageId(Long garageId) {
        this.garageId = garageId;
    }

    // Method to convert the scheduledDate string to LocalDate
    public LocalDate getScheduledDateAsLocalDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(scheduledDate, formatter);
    }

    @Override
    public String toString() {
        return "CreateMaintenanceDTO{" +
                "carId=" + carId +
                ", serviceType='" + serviceType + '\'' +
                ", scheduledDate='" + scheduledDate + '\'' +
                ", garageId=" + garageId +
                '}';
    }
}


