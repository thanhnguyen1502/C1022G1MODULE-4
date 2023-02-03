package com.example.service.impl;

import com.example.model.Customer;
import com.example.service.ICustomerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class CustomerService implements ICustomerService {
    private static Map<Integer, Customer> customerList;
    static {
        customerList = new HashMap<>();
        customerList.put(1, new Customer(1,"Casiopesia","casiopesia@gmail.com","vn"));
        customerList.put(2, new Customer(2, "Lee Sin", "leesin@gmail.com", "kr"));
        customerList.put(3, new Customer(3, "Graves", "graves@gmail.com", "jp"));
        customerList.put(4, new Customer(4, "Yasuo", "yasuo@gmail.com", "cn"));
    }
    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customerList.values());
    }

    @Override
    public void save(Customer customer) {
        customerList.put(customer.getId(), customer);
    }

    @Override
    public Customer findById(int id) {
        return customerList.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customerList.put(id, customer);
    }

    @Override
    public void remove(int id) {
        customerList.remove(id);
    }
}
