package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.VehicleEntity;

public interface VehicleRepo extends JpaRepository<VehicleEntity, Long> {
    // custom queries if needed
}
