package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void add(Product product);
    void update( Product product);
    void remove(int id);
    Product findByName(String name, Product product);
    Product findById(int id);
}
