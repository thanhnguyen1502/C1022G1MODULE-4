package com.codegym.repository;

import com.codegym.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    void add(Product product);
    void update( Product product);
    void remove(int id);
    Product findByName(String name, Product product);
    Product findById(int id);

}
