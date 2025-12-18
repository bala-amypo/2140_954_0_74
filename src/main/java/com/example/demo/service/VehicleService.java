public VehicleEntity insertVehicle(VehicleEntity vehicle) {
    return vehicleRepo.save(vehicle);
}

public List<VehicleEntity> getAllVehicles() {
    return vehicleRepo.findAll();
}

public Optional<VehicleEntity> getOneVehicle(Long id) {
    return vehicleRepo.findById(id);
}

public VehicleEntity updateVehicle(Long id, VehicleEntity newVehicle) {
    return vehicleRepo.findById(id)
            .map(vehicle -> {
                vehicle.setBrand(newVehicle.getBrand());
                vehicle.setModel(newVehicle.getModel());
                vehicle.setYear(newVehicle.getYear());
                return vehicleRepo.save(vehicle);
            }).orElse(null);
}

public boolean deleteVehicle(Long id) {
    if (vehicleRepo.existsById(id)) {
        vehicleRepo.deleteById(id);
        return true;
    }
    return false;
}
