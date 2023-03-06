package com.example.test2.service;

import com.example.test2.model.Student;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface IStudentService {
    List<Student> findAllByName(String nameSearch);

    Student findById(Integer id);

    void remove(Integer id);

    void save(Student student);
}
