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

    // UPDATE
    public VehicleEntity updateVehicle(Long id, VehicleEntity newVehicle) {
        return vehicleRepo.findById(id)
            .map(vehicle -> {
                vehicle.setMake(newVehicle.getMake());
                vehicle.setModel(newVehicle.getModel());
                vehicle.setYear(newVehicle.getYear());
                vehicle.setColor(newVehicle.getColor());
                return vehicleRepo.save(vehicle);
            }).orElse(null);
    }

    // DELETE
    public boolean deleteVehicle(Long id) {
        if (vehicleRepo.existsById(id)) {
            vehicleRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
