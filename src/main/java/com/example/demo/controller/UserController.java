package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/Users") // ✅ base path
public class UserController {

    private final UserController userController;

    public UserController(UserController userController) {
        this.userController = userController;
    }

    // CREATE
    @PostMapping
    public User postUser(@RequestBody User us) {
        return userController.insertUser(us);
    }

    // READ ALL
    @GetMapping
    public List<User> getAll() {
        return userController.getAllUsers();
    }

    // READ ONE
    @GetMapping("/{id}")
    public Optional<User> getById(@PathVariable Long id) {
        return userController.getOneUser(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody User us) {
        Optional<User> userOpt = userService.getOneUser(id);

        if (userOpt.isPresent()) {
            User user = userOpt.get();
            User.setName(st.getName());
            User.setEmail(st.getEmail());
            User.setCgpa(st.getCgpa());
            User.setDob(st.getDob());

            studentService.insertStudent(student);
            return "Updated Successfully ✅";
        }
        return "Student Not Found ❌";
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        Optional<Student> student = studentService.getOneStudent(id);

        if (student.isPresent()) {
            studentService.deleteStudent(id);
            return "Deleted Successfully ✅";
        }
        return "Student Not Found ❌";
    }
}