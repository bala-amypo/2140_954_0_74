package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepo;

@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    // CREATE / UPDATE
    public User insertUser(User user) {
        return userRepo.save(user);
    }

    // READ ALL
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    // READ ONE
    public Optional<User> getOneUser(Long id) {
        return userRepo.findById(id);
    }

    // DELETE
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }
}
