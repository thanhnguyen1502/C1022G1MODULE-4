package com.example.execrise.service.impl;

import com.example.execrise.model.Product;
import com.example.execrise.repository.ICartRepository;
import com.example.execrise.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CartService implements ICartService {
    @Autowired
    private ICartRepository cartRepository;

    @Override
    public void addProduct(Map<Product, Integer> cart, Product product) {
        cartRepository.addProduct(cart,product);
    }

    @Override
    public double getTotal(Map<Product, Integer> cart) {
        return cartRepository.getTotal(cart);
    }
}
