package com.example.car_management.repository;

import com.example.car_management.model.MaintenanceRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MaintenanceRequestRepository extends JpaRepository<MaintenanceRequest, Long> {

    // Find all maintenance requests for a specific car
    List<MaintenanceRequest> findAllByCarId(Long carId);

    // Find all maintenance requests for a specific service center
    List<MaintenanceRequest> findAllByServiceCenterId(Long serviceCenterId);

    // Find maintenance requests for a specific car and service center
    List<MaintenanceRequest> findAllByCarIdAndServiceCenterId(Long carId, Long serviceCenterId);

    // Find maintenance requests for a specific car and service center within a date range
    List<MaintenanceRequest> findAllByCarIdAndServiceCenterIdAndRequestDateBetween(
            Long carId, Long serviceCenterId, LocalDate startDate, LocalDate endDate);

    // Find maintenance requests for a specific service center within a date range
    List<MaintenanceRequest> findAllByServiceCenterIdAndRequestDateBetween(
            Long serviceCenterId, LocalDate startDate, LocalDate endDate);

    List<MaintenanceRequest> findByCarId(Long carId);

    List<MaintenanceRequest> findByCarIdAndServiceCenterId(Long carId, Long garageId);

    List<MaintenanceRequest> findByCarIdAndServiceCenterIdAndRequestDateBetween(Long carId, Long garageId, LocalDate start, LocalDate end);

    List<MaintenanceRequest> findByServiceCenterId(Long garageId);

    List<MaintenanceRequest> findByServiceCenterIdAndRequestDateBetween(Long garageId, LocalDate start, LocalDate end);
}

