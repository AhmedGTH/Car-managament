package com.example.car_management.controller;

import com.example.car_management.dto.CreateMaintenanceDTO;
import com.example.car_management.dto.UpdateMaintenanceDTO;
import com.example.car_management.model.MaintenanceRequest;
import com.example.car_management.service.MaintenanceRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/maintenance")
public class MaintenanceRequestController {

    private final MaintenanceRequestService maintenanceRequestService;

    // Constructor injection for better testability
    @Autowired
    public MaintenanceRequestController(MaintenanceRequestService maintenanceRequestService) {
        this.maintenanceRequestService = maintenanceRequestService;
    }

    // Create a new maintenance request
    @PostMapping
    public ResponseEntity<MaintenanceRequest> createMaintenanceRequest(
            @Valid @RequestBody CreateMaintenanceDTO requestDto) {
        MaintenanceRequest createdRequest = maintenanceRequestService.createMaintenanceRequest(requestDto);
        return ResponseEntity.ok(createdRequest);
    }

    // Update an existing maintenance request
    @PutMapping("/{id}")
    public ResponseEntity<MaintenanceRequest> updateMaintenanceRequest(
            @PathVariable Long id,
            @Valid @RequestBody UpdateMaintenanceDTO requestDto) {
        return maintenanceRequestService.updateMaintenanceRequest(id, requestDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Retrieve a maintenance request by ID
    @GetMapping("/{id}")
    public ResponseEntity<MaintenanceRequest> getMaintenanceRequestById(@PathVariable Long id) {
        return maintenanceRequestService.getMaintenanceRequestById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Retrieve all maintenance requests with optional filters
    @GetMapping
    public ResponseEntity<List<MaintenanceRequest>> getAllMaintenanceRequests(
            @RequestParam(required = false) Long carId,
            @RequestParam(required = false) Long garageId,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") String startDate,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") String endDate) {
        List<MaintenanceRequest> requests = maintenanceRequestService.getFilteredMaintenanceRequests(carId, garageId, startDate, endDate);
        return ResponseEntity.ok(requests);
    }

    // Generate a monthly report for maintenance requests
    @GetMapping("/monthly-report")
    public ResponseEntity<List<MaintenanceRequest>> getMonthlyRequestsReport(
            @RequestParam Long garageId,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM") String startMonth,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM") String endMonth) {
        List<MaintenanceRequest> report = maintenanceRequestService.getMonthlyRequestsReport(garageId, startMonth, endMonth);
        return ResponseEntity.ok(report);
    }

    // Generate a daily availability report
    @GetMapping("/daily-availability")
    public ResponseEntity<List<MaintenanceRequest>> getDailyAvailabilityReport(
            @RequestParam Long garageId,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") String startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") String endDate) {
        List<MaintenanceRequest> report = maintenanceRequestService.getDailyAvailabilityReport(garageId, startDate, endDate);
        return ResponseEntity.ok(report);
    }
}

