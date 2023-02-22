package com.example.casestudy.service.impl.customer;

import com.example.casestudy.dto.customer.CustomerDto;
import com.example.casestudy.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface ICustomerService {
    Page<Customer> findAllByNameContaining(String nameCustomer, Pageable pageable);

    Page<Customer> findAllByContracts_EndDateBefore(String now, Pageable pageable);


    Map<String, String> messDto(CustomerDto customerDto);

    void save(Customer customer);

    Customer findById(int id);

    void deleteById(int id);
}
