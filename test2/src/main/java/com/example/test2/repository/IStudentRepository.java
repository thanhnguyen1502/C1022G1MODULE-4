package com.example.test2.repository;

import com.example.test2.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IStudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findAllByNameContaining(String searchName);
}
