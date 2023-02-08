package com.example.execrise.service.impl;

import com.example.execrise.model.Catelory;
import com.example.execrise.repository.ICateloryRepository;
import com.example.execrise.service.ICateloryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CateloryRepository implements ICateloryService {
    @Autowired
    private ICateloryRepository cateloryRepository;


    @Override
    public List<Catelory> findAll() {
        return cateloryRepository.findAll();
    }

    @Override
    public void save(Catelory category) {
        cateloryRepository.save(category);
    }

    @Override
    public Catelory findById(Integer id) {
        return cateloryRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
    cateloryRepository.delete(findById(id));
    }
}
