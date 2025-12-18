package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.VehicleEntity;
import com.example.demo.service.VehicleService;

@RestController
@RequestMapping("/vehicles") // base path
public class VehicleController {

    private final VehicleService vehicleService;

    // Constructor injection
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    // CREATE
    @PostMapping
    public VehicleEntity createVehicle(@RequestBody VehicleEntity vehicle) {
        return vehicleService.insertVehicle(vehicle);
    }

    // READ ALL
    @GetMapping
    public List<VehicleEntity> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    // READ ONE
    @GetMapping("/{id}")
    public Optional<VehicleEntity> getVehicleById(@PathVariable Long id) {
        return vehicleService.getOneVehicle(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public String updateVehicle(@PathVariable Long id, @RequestBody VehicleEntity vehicleDetails) {
        Optional<VehicleEntity> vehicleOpt = vehicleService.getOneVehicle(id);

        if (vehicleOpt.isPresent()) {
            VehicleEntity vehicle = vehicleOpt.get();
            vehicle.setName(vehicleDetails.getName());
            vehicle.setType(vehicleDetails.getType());
            vehicle.setModel(vehicleDetails.getModel());
            vehicle.setOwner(vehicleDetails.getOwner());

            vehicleService.insertVehicle(vehicle); // save updated vehicle
            return "Vehicle Updated Successfully ✅";
        }
        return "Vehicle Not Found ❌";
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteVehicle(@PathVariable Long id) {
        Optional<VehicleEntity> vehicleOpt = vehicleService.getOneVehicle(id);

        if (vehicleOpt.isPresent()) {
            vehicleService.deleteVehicle(id);
            return "Vehicle Deleted Successfully ✅";
        }
        return "Vehicle Not Found ❌";
    }
}
