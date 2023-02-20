package com.example.casestudy.service.impl.customer;

import com.example.casestudy.model.customer.Customer;
import com.example.casestudy.repository.customer.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;
    @Override
    public Page<Customer> findAllByNameContaining(String nameCustomer, Pageable pageable) {
        return customerRepository.findAllByNameContaining(nameCustomer,pageable);
    }

    @Override
    public Page<Customer> findAllByContracts_EndDateBefore(String now, Pageable pageable) {
        return customerRepository.findAllByContracts_EndDateGreaterThan(now, pageable);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.getById(id);
    }

    @Override
    public void deleteById(int id) {
        customerRepository.deleteById(id);
    }
}
