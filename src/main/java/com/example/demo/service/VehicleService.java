package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.VehicleEntity;
import com.example.demo.repository.VehicleRepo;

@Service
public class VehicleService {

    private final VehicleRepo vehicleRepo;

    public VehicleService(VehicleRepo vehicleRepo) {
        this.vehicleRepo = vehicleRepo;
    }

    // CREATE / UPDATE
    public VehicleEntity insertVehicle(VehicleEntity vehicle) {
        return vehicleRepo.save(vehicle);
    }

    // READ ALL
    public List<VehicleEntity> getAllVehicles() {
        return vehicleRepo.findAll();
    }

    // READ ONE
    public Optional<VehicleEntity> getOneVehicle(Long id) {
        return vehicleRepo.findById(id);
    }

    // DELETE
    public void deleteVehicle(Long id) {
        vehicleRepo.deleteById(id);
    }
}
