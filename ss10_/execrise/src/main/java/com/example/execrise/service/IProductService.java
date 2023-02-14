package com.example.execrise.service;

import com.example.execrise.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(Long id);
}
