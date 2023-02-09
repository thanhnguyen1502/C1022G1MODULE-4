package com.example.execrise.service;

import com.example.execrise.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    void save(Category category);

    Category findById(Integer id);

    void delete(Integer id);
}
