package com.example.execrise.repository;

import com.example.execrise.model.Product;

import java.util.Map;

public interface ICartRepository {
    void addProduct(Map<Product, Integer> cart, Product product);

    double getTotal(Map<Product, Integer> cart);
}
