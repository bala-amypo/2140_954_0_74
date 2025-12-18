package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.VehicleEntity;

@Repository
public interface VehicleRepo extends JpaRepository<VehicleEntity, Long> {
    // Add custom queries here if needed, e.g., find by owner
}
