package com.example.car_management.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UpdateMaintenanceDTO {

    @NotNull
    private Long carId;

    @NotNull
    @Size(min = 1, max = 50)
    private String serviceType;

    @NotNull
    private String scheduledDate;

    private Long garageId;

    // Constructors
    public UpdateMaintenanceDTO() {}

    public UpdateMaintenanceDTO(Long carId, String serviceType, String scheduledDate, Long garageId) {
        this.carId = carId;
        this.serviceType = serviceType;
        this.scheduledDate = scheduledDate;
        this.garageId = garageId;
    }

    // Getter and Setter methods

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

    @Override
    public String toString() {
        return "UpdateMaintenanceDTO{" +
                "carId=" + carId +
                ", serviceType='" + serviceType + '\'' +
                ", scheduledDate='" + scheduledDate + '\'' +
                ", garageId=" + garageId +
                '}';
    }
}

