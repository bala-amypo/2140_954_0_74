package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Studententity;
import com.example.demo.service.Studentservice;

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

    @GetMapping("/get/{id}")
    public Optional<Studententity> getStudent(@PathVariable Long id) {
        return ser.getOneStudent(id);
    }

    @PutMapping("/update/{id}")
    public String  updateStudent(@PathVariable Long id , @RequestBody Studententity newStudententity) {
        Optional<Studententity> student = ser.getOneStudent(id);
        if(student.isPresent()) {
            newStudententity.setId(id);
            ser.insertStudententity(newStudententity);
            return "Updated Successfully";
        }
        return "Id not found";
    }

    @DeleteMapping("/del/{id}")
    public String deleteStudent(@PathVariable Long id){
        Optional<Studententity> student = ser.getOneStudent(id);
        if(student.isPresent()){
            ser.deleteStudent(id);
            return "Deleted Successfully";
        }
        return "Id not found";
    }
}