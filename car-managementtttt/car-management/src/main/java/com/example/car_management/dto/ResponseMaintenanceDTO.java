package com.example.car_management.dto;

public class ResponseMaintenanceDTO {

    private Long id;
    private Long carId;
    private String carName;
    private String serviceType;
    private String scheduledDate;
    private Long garageId;
    private String garageName;

    // Constructors
    public ResponseMaintenanceDTO() {}

    public ResponseMaintenanceDTO(Long id, Long carId, String carName, String serviceType,
                                  String scheduledDate, Long garageId, String garageName) {
        this.id = id;
        this.carId = carId;
        this.carName = carName;
        this.serviceType = serviceType;
        this.scheduledDate = scheduledDate;
        this.garageId = garageId;
        this.garageName = garageName;
    }

    // Getter and Setter methods

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

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
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

    public String getGarageName() {
        return garageName;
    }

    public void setGarageName(String garageName) {
        this.garageName = garageName;
    }

    @Override
    public String toString() {
        return "ResponseMaintenanceDTO{" +
                "id=" + id +
                ", carId=" + carId +
                ", carName='" + carName + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", scheduledDate='" + scheduledDate + '\'' +
                ", garageId=" + garageId +
                ", garageName='" + garageName + '\'' +
                '}';
    }
}

