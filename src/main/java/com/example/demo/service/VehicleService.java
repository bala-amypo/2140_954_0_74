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

    // CREATE
    public VehicleEntity saveVehicle(VehicleEntity vehicle) {
        return vehicleRepo.save(vehicle);
    }

    // READ ALL
    public List<VehicleEntity> getAllVehicles() {
        return vehicleRepo.findAll();
    }

    // READ ONE
    public Optional<VehicleEntity> getVehicleById(Long id) {
        return vehicleRepo.findById(id);
    }

    // UPDATE
    public VehicleEntity updateVehicle(Long id, VehicleEntity newVehicle) {
        return vehicleRepo.findById(id).map(vehicle -> {
            vehicle.setBrand(newVehicle.getBrand());
            vehicle.setModel(newVehicle.getModel());
            vehicle.setYear(newVehicle.getYear());
            return vehicleRepo.save(vehicle);
        }).orElse(null);
    }

    // DELETE
    public void deleteVehicle(Long id) {
        vehicleRepo.deleteById(id);
    }
}
