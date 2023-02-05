package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "iphone", "15000", "Apple"));
        products.add(new Product(2, "note7", "17000", "Samsung"));
        products.add(new Product(3, "galaxy", "12000", "galaxy"));
        products.add(new Product(4, "motorola", "10000", "motorola"));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public void update(Product product) {
        for (Product p : products) {
            if (p.getId() == product.getId()) {
//                p.setName(product.getName());
//                p.setPrice(product.getPrice());
//                p.setDescription(product.getDescription());
//                p.setManufacture(product.getManufacture());
                BeanUtils.copyProperties(product, p);
            }
        }
    }

    @Override
    public void remove(int id) {
        products.remove(id);

    }

    @Override
    public Product findByName(String name) {
                List<Product> result = new ArrayList<>();
        for (Product p : products){
            if(p.getName().toLowerCase().contains(name.toLowerCase())){
                result.add(p);
            }
        }
        return result;
    }

    @Override
    public Product findById(int id) {
        Product product = null;
        for (Product p : products) {
            if (p.getId() == id) {
                product = p;
            }
        }
        return product;
    }

    @Override
    public Product showDetail(int id) {
        for (Product p : products) {
            if (p.getId() == id)
                return p;
        }
        return null;
    }
}
