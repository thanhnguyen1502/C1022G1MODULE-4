package com.example.execrise.service.impl;

import com.example.execrise.model.Category;
import com.example.execrise.repository.ICategoryRepository;
import com.example.execrise.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public Category findCategoryById(int id) {
        return categoryRepository.findById(id).orElse(new Category());
    }

    @Override
    public void saveCategory(Category category) {
    categoryRepository.save(category);
    }

    @Override
    public Page<Category> findAllCategory(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public void deleteCategoryById(int id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }
}
