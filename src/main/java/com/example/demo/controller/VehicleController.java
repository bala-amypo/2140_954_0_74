package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.VehicleEntity;
import com.example.demo.service.VehicleService;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    // CREATE
    @PostMapping
    public VehicleEntity createVehicle(@RequestBody VehicleEntity vehicle) {
        return vehicleService.saveVehicle(vehicle);
    }

    // READ ALL
    @GetMapping
    public List<VehicleEntity> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    // READ ONE
    @GetMapping("/{id}")
    public Optional<VehicleEntity> getVehicleById(@PathVariable Long id) {
        return vehicleService.getVehicleById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public VehicleEntity updateVehicle(
            @PathVariable Long id,
            @RequestBody VehicleEntity vehicle) {

        return vehicleService.updateVehicle(id, vehicle);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
        return "Vehicle deleted successfully ✅";
    }
}
