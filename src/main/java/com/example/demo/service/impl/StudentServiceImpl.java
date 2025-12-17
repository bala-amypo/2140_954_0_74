package com.example.demo.service.Impl;

import java.util.*;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Studententity;
import com.example.demo.service.Studentservice;

@Service
public class StudentServiceImpl implements Studentservice {

    private final Map<Long, Studententity> store = new HashMap<>();
    private long counter = 1;

    @Override
    public Studententity insertStudententity(Studententity st) {
        st.setId(counter++);
        store.put(st.getId(), st);
        return st;
    }

    @Override
    public List<Studententity> getAllStudententity() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Optional<Studententity> getOneStudent(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public void deleteStudent(Long id){
        store.remove(id);
    }
}
