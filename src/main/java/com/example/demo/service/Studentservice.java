package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import com.example.demo.entity.Studententity;

public interface Studentservice{

    Studententity insertStudententity(Studententity st);
    List <Studententity> getAllStudententity();
    Optional<Studententity>getOneStudent(Long id);
    void deleteStudent(Long id);
}