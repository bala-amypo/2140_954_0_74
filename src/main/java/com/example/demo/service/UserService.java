package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepo;

@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    // CREATE
    public UserEntity insertUser(UserEntity user) {
        return userRepo.save(user);
    }

    // READ ALL
    public List<UserEntity> getAllUsers() {
        return userRepo.findAll();
    }

    // READ ONE
    public Optional<UserEntity> getOneUser(Long id) {
        return userRepo.findById(id);
    }

    // UPDATE
    public UserEntity updateUser(Long id, UserEntity newUser) {
        return userRepo.findById(id)
            .map(user -> {
                user.setName(newUser.getName());
                user.setEmail(newUser.getEmail());
                user.setCgpa(newUser.getCgpa());
                user.setDob(newUser.getDob());
                return userRepo.save(user);
            }).orElse(null);
    }

    // DELETE
    public boolean deleteUser(Long id) {
        if (userRepo.existsById(id)) {
            userRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
