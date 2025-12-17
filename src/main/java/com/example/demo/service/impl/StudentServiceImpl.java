package com.example.demo.service.impl;

import com.example.demo.entity.Studententity;
import com.example.demo.repository.Studentrepository;
import com.example.demo.service.Studentservice;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements Studentservice {

    private final Studentrepository studentrepository;

    public StudentServiceImpl(Studentrepository studentrepository) {
        this.studentrepository = studentrepository;
    }

    @Override
    public Studententity insertStudententity(Studententity st) {
        return studentrepository.save(st);
    }

    @Override
    public List<Studententity> getAllStudententity() {
        return studentrepository.findAll();
    }

    @Override
    public Optional<Studententity> getOneStudent(Long id) {
        return studentrepository.findById(id);
    }

    @Override
    public void deleteStudent(Long id) {
        studentrepository.deleteById(id);
    }
}
