package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Long> {
    // You can add custom queries here if needed
}
