package com.example.execrise.service;

import com.example.execrise.model.Catelory;

import java.util.List;

public interface ICateloryService {
    List<Catelory> findAll();

    void save(Catelory category);

    Catelory findById(Integer id);

    void delete(Integer id);
}
