package com.example.test2.service.impl;

import com.example.test2.model.Student;
import com.example.test2.repository.IStudentRepository;
import com.example.test2.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository studentRepository;
    @Override
    public List<Student> findAllByName(String nameSearch) {
        return studentRepository.findAllByNameContaining(nameSearch);
    }

    @Override
    public Student findById(Integer id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(Integer id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }
}
