package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.VehicleEntity;
import com.example.demo.repository.VehicleRepo;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    // 👇 This runs once when the app starts
    @Bean
    CommandLineRunner insertVehicles(VehicleRepo vehicleRepo) {
        return args -> {

            VehicleEntity v1 = new VehicleEntity();
            v1.setBrand("Toyota");
            v1.setModel("Corolla");
            v1.setYear(2023);

            VehicleEntity v2 = new VehicleEntity();
            v2.setBrand("Honda");
            v2.setModel("Civic");
            v2.setYear(2022);

            vehicleRepo.save(v1);
            vehicleRepo.save(v2);

            System.out.println("✅ Vehicles inserted successfully");
        };
    }
}
