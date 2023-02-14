package com.example.execrise.service;

import com.example.execrise.model.Product;

import java.util.Map;

public interface ICartService {
    void addProduct(Map<Product, Integer> cart, Product product);
    double getTotal(Map<Product,Integer> cart);
}
