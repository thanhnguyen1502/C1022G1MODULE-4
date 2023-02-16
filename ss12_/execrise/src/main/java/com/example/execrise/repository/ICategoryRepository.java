package com.example.execrise.repository;

import com.example.execrise.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer> {
    Category findCategoryById(int id);
}