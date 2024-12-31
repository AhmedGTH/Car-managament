package com.example.car_management.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;

public class UpdateCarDTO {

    @NotNull
    @Size(min = 1, max = 50)
    private String make;

    @NotNull
    @Size(min = 1, max = 50)
    private String model;

    @NotNull
    private Integer productionYear;

    @NotNull
    @Size(min = 1, max = 20)
    private String licensePlate;

    private List<Long> garageIds;

    // Constructors
    public UpdateCarDTO() {}

    public UpdateCarDTO(String make, String model, Integer productionYear, String licensePlate, List<Long> garageIds) {
        this.make = make;
        this.model = model;
        this.productionYear = productionYear;
        this.licensePlate = licensePlate;
        this.garageIds = garageIds;
    }

    // Getter and Setter methods

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(Integer productionYear) {
        this.productionYear = productionYear;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public List<Long> getGarageIds() {
        return garageIds;
    }

    public void setGarageIds(List<Long> garageIds) {
        this.garageIds = garageIds;
    }

    @Override
    public String toString() {
        return "UpdateCarDTO{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", productionYear=" + productionYear +
                ", licensePlate='" + licensePlate + '\'' +
                ", garageIds=" + garageIds +
                '}';
    }
}

