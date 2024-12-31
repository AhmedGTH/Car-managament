package com.example.car_management.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateCarDTO {

    @NotNull(message = "Make is required")
    @Size(min = 1, max = 50, message = "Make must be between 1 and 50 characters")
    private String make;

    @NotNull(message = "Model is required")
    @Size(min = 1, max = 50, message = "Model must be between 1 and 50 characters")
    private String model;

    @NotNull(message = "Production year is required")
    private Integer productionYear;

    // Constructors
    public CreateCarDTO() {}

    public CreateCarDTO(String make, String model, Integer productionYear) {
        this.make = make;
        this.model = model;
        this.productionYear = productionYear;
    }

    // Getter and Setter methods using the latest conventions

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

    @Override
    public String toString() {
        return "CreateCarDTO{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", productionYear=" + productionYear +
                '}';
    }
}


