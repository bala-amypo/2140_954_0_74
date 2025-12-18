package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.User;
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
    public User createUser(@RequestBody User user) {
        return userService.insertUser(user);
    }

    // READ ALL
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // READ ONE
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getOneUser(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        Optional<User> userOpt = userService.getOneUser(id);

        if (userOpt.isPresent()) {
            User user = userOpt.get();
            user.setName(userDetails.getName());
            user.setEmail(userDetails.getEmail());
            user.setCgpa(userDetails.getCgpa());
            user.setDob(userDetails.getDob());

            userService.insertUser(user); // save updated user
            return "User Updated Successfully ✅";
        }
        return "User Not Found ❌";
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        Optional<User> userOpt = userService.getOneUser(id);

        if (userOpt.isPresent()) {
            userService.deleteUser(id);
            return "User Deleted Successfully ✅";
        }
        return "User Not Found ❌";
    }
}
