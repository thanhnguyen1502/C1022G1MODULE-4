package com.example.casestudy.service.customer;

import com.example.casestudy.dto.customer.CustomerDto;
import com.example.casestudy.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface ICustomerService {

    Page<Customer> searchCustomer(String nameSearch, String emailSearch, Pageable pageable);

    Page<Customer> searchCustomerType(String nameSearch, String emailSearch, Integer customerType, Pageable pageable);

    Map<String, String> messDto(CustomerDto customerDto);

    void save(Customer customer);

    Customer findById(int id);

    void deleteById(int id);
}
