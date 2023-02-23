package com.example.casestudy.service.impl.customer;

import com.example.casestudy.dto.customer.CustomerDto;
import com.example.casestudy.model.customer.Customer;
import com.example.casestudy.repository.customer.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;


//    @Override
//    public Page<Customer> findAllByNameContaining(String nameCustomer, Pageable pageable) {
//        return customerRepository.findAllByNameContaining(nameCustomer, pageable);
//    }
//
//    @Override
//    public Page<Customer> findAllByContracts_EndDateBefore(String now, Pageable pageable) {
//        return customerRepository.findAllByContracts_EndDateGreaterThan(now, pageable);
//    }

    @Override
    public Page<Customer> searchCustomer(String nameSearch, String emailSearch, Pageable pageable) {
        return customerRepository.searchCustomer(nameSearch,emailSearch,pageable);
    }

    @Override
    public Page<Customer> searchCustomerType(String nameSearch, String emailSearch, Integer customerType, Pageable pageable) {
        return customerRepository.searchCustomerType(nameSearch,emailSearch,customerType,pageable);
    }

    @Override
    public Map<String, String> messDto(CustomerDto customerDto) {
        Map<String, String> messError = new HashMap<>();
        for (Customer customer: customerRepository.findAll()){
            if (customer.getIdCard().equals(customerDto.getIdCard())){
                messError.put("Id Card","Id Card đã tồn tại!!");
            }
            if (customer.getEmail().equals(customerDto.getEmail())){
                messError.put("Email","Email đã tồn tại!!");
            }
            if (customer.getPhoneNumber().equals(customerDto.getPhoneNumber())){
                messError.put("Số điện thoại","Số điện thoại đã tồn tại!!");
            }
        }
        return messError;
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
