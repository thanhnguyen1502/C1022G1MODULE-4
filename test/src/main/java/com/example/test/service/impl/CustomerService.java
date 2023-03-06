package com.example.test.service.impl;

import com.example.test.model.Customer;
import com.example.test.repository.ICustomerRepository;
import com.example.test.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public void remove(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> findByname(String nameSearch) {
        return customerRepository.findAllByNameContaining(nameSearch);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findById(Integer id) {
       return customerRepository.findById(id).get();
    }
}
