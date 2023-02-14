package com.example.practice.service;

import com.example.practice.model.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();
    Optional<Product> findById(long id);
}
