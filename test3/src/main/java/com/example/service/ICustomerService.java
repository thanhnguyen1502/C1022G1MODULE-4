package com.example.service;

import com.example.model.Customer;

import java.util.List;

public interface ICustomerService {

    void remove(Integer id);

    void save(Customer customer);

    List<Customer> findAllByName(String nameSearch);

    Customer findByid(Integer id);

}
