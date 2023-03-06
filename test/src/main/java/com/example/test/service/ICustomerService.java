package com.example.test.service;

import com.example.test.model.Customer;

import java.util.List;

public interface ICustomerService {

    void remove(Integer id);

    void save(Customer customer);

    List<Customer> findByname(String nameSearch);

    Customer findById(Integer id);

}
