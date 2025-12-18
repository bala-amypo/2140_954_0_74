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
    public VehicleEntity postVehicle(@RequestBody VehicleEntity vehicle) {
        return vehicleService.insertVehicle(vehicle);
    }

    // READ ALL
    @GetMapping
    public List<VehicleEntity> getAll() {
        return vehicleService.getAllVehicles();
    }

    // READ ONE
    @GetMapping("/{id}")
    public Optional<VehicleEntity> getById(@PathVariable Long id) {
        return vehicleService.getOneVehicle(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public String updateVehicle(@PathVariable Long id, @RequestBody VehicleEntity vehicle) {
        VehicleEntity updated = vehicleService.updateVehicle(id, vehicle);
        return updated != null ? "Updated Successfully ✅" : "Vehicle Not Found ❌";
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteVehicle(@PathVariable Long id) {
        return vehicleService.deleteVehicle(id) ? "Deleted Successfully ✅" : "Vehicle Not Found ❌";
    }
}
ss -lntp | grep 9001
