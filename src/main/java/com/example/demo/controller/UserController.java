package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // CREATE
    @PostMapping
    public UserEntity postUser(@RequestBody UserEntity user) {
        return userService.insertUser(user);
    }

    // READ ALL
    @GetMapping
    public List<UserEntity> getAll() {
        return userService.getAllUsers();
    }

    // READ ONE
    @GetMapping("/{id}")
    public Optional<UserEntity> getById(@PathVariable Long id) {
        return userService.getOneUser(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody UserEntity user) {
        UserEntity updated = userService.updateUser(id, user);
        return updated != null ? "Updated Successfully ✅" : "User Not Found ❌";
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id) ? "Deleted Successfully ✅" : "User Not Found ❌";
    }
}
