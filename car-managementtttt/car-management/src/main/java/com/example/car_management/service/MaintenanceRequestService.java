package com.example.car_management.service;

import com.example.car_management.dto.CreateMaintenanceDTO;
import com.example.car_management.dto.UpdateMaintenanceDTO;
import com.example.car_management.model.MaintenanceRequest;
import com.example.car_management.repository.MaintenanceRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceRequestService {

    @Autowired
    private MaintenanceRequestRepository maintenanceRequestRepository;

    // Create a new maintenance request
    public MaintenanceRequest createMaintenanceRequest(CreateMaintenanceDTO maintenanceRequestDto) {
        MaintenanceRequest maintenanceRequest = new MaintenanceRequest();

        // Set carId and serviceCenterId
        maintenanceRequest.setCarId(maintenanceRequestDto.getCarId());
        maintenanceRequest.setServiceCenterId(maintenanceRequestDto.getGarageId());

        // Convert the scheduledDate (String) to LocalDate
        try {
            LocalDate scheduledDate = LocalDate.parse(maintenanceRequestDto.getScheduledDate());
            maintenanceRequest.setRequestDate(scheduledDate);  // Set the parsed date
        } catch (DateTimeParseException e) {
            // Handle invalid date format
            throw new IllegalArgumentException("Invalid date format for scheduledDate. Expected format: yyyy-MM-dd");
        }

        // Set service type
        maintenanceRequest.setServiceType(maintenanceRequestDto.getServiceType());

        // Save the request to the repository and return
        return maintenanceRequestRepository.save(maintenanceRequest);
    }

    // Update an existing maintenance request
    public Optional<MaintenanceRequest> updateMaintenanceRequest(Long id, UpdateMaintenanceDTO maintenanceRequestDto) {
        Optional<MaintenanceRequest> existingRequest = maintenanceRequestRepository.findById(id);
        if (existingRequest.isPresent()) {
            MaintenanceRequest maintenanceRequest = existingRequest.get();
            if (maintenanceRequestDto.getServiceType() != null) maintenanceRequest.setServiceType(maintenanceRequestDto.getServiceType());
            if (maintenanceRequestDto.getScheduledDate() != null) {
                try {
                    LocalDate scheduledDate = LocalDate.parse(maintenanceRequestDto.getScheduledDate());
                    maintenanceRequest.setRequestDate(scheduledDate);  // Update the request date
                } catch (DateTimeParseException e) {
                    throw new IllegalArgumentException("Invalid date format for scheduledDate. Expected format: yyyy-MM-dd");
                }
            }
            return Optional.of(maintenanceRequestRepository.save(maintenanceRequest));
        }
        return Optional.empty();
    }

    // Fetch a maintenance request by its ID
    public Optional<MaintenanceRequest> getMaintenanceRequestById(Long id) {
        return maintenanceRequestRepository.findById(id);
    }

    // Get filtered maintenance requests based on carId, service center, and date range
    public List<MaintenanceRequest> getFilteredMaintenanceRequests(Long carId, Long garageId, String startDate, String endDate) {
        LocalDate start = null;
        LocalDate end = null;

        // Parse dates and handle any exceptions
        try {
            if (startDate != null && !startDate.isEmpty()) {
                start = LocalDate.parse(startDate);
            }
            if (endDate != null && !endDate.isEmpty()) {
                end = LocalDate.parse(endDate);
            }
        } catch (DateTimeParseException e) {
            return List.of();  // Return an empty list if date parsing fails
        }

        // Query repository based on filters
        if (carId != null && garageId != null && start != null && end != null) {
            return maintenanceRequestRepository.findByCarIdAndServiceCenterIdAndRequestDateBetween(carId, garageId, start, end);
        } else if (carId != null && garageId != null) {
            return maintenanceRequestRepository.findByCarIdAndServiceCenterId(carId, garageId);
        } else if (carId != null) {
            return maintenanceRequestRepository.findByCarId(carId);
        } else if (garageId != null) {
            return maintenanceRequestRepository.findByServiceCenterId(garageId);
        } else {
            return maintenanceRequestRepository.findAll();  // No filters, return all requests
        }
    }

    // Get a report of monthly maintenance requests
    public List<MaintenanceRequest> getMonthlyRequestsReport(Long garageId, String startMonth, String endMonth) {
        LocalDate start = LocalDate.parse(startMonth + "-01");
        LocalDate end = LocalDate.parse(endMonth + "-01").plusMonths(1);  // Move to the next month for the end date
        return maintenanceRequestRepository.findByServiceCenterIdAndRequestDateBetween(garageId, start, end);
    }

    // Get a daily availability report of maintenance requests
    public List<MaintenanceRequest> getDailyAvailabilityReport(Long garageId, String startDate, String endDate) {
        return maintenanceRequestRepository.findByServiceCenterIdAndRequestDateBetween(
                garageId,
                LocalDate.parse(startDate),
                LocalDate.parse(endDate)
        );
    }
}

