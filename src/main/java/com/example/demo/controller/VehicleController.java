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

    @PostMapping
    public VehicleEntity createVehicle(@RequestBody VehicleEntity vehicle) {
        return vehicleService.insertVehicle(vehicle);
    }

    @GetMapping
    public List<VehicleEntity> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @GetMapping("/{id}")
    public Optional<VehicleEntity> getVehicleById(@PathVariable Long id) {
        return vehicleService.getOneVehicle(id);
    }

    @PutMapping("/{id}")
    public VehicleEntity updateVehicle(@PathVariable Long id, @RequestBody VehicleEntity vehicle) {
        return vehicleService.updateVehicle(id, vehicle);
    }

    @DeleteMapping("/{id}")
    public String deleteVehicle(@PathVariable Long id) {
        return vehicleService.deleteVehicle(id) ? "Deleted Successfully ✅" : "Vehicle Not Found ❌";
    }
}
