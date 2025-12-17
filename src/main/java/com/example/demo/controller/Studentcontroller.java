package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Studentity;
import coom.example.demo.service.Studentservice;

@RestController
@RequestMapping("/student")
public class Studentcontroller {

    private final Studentservice ser;

    @Autowired
    public Studentcontroller(Studentservice ser) {
        this.ser = ser;
    }

    @PostMapping("/add")
    public Studententity addStudent(@RequestBody Studententity st) {
        return ser.insertStudententity(st);
    }

    @GetMapping("/getAll")
    public List<Studententity> getAllStudents() {
        return ser.getAllStudententity();
    }
    


}