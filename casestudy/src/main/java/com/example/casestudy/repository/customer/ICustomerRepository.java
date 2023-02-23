package com.example.casestudy.repository.customer;

import com.example.casestudy.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
//    Page<Customer> findAllByNameContaining(String nameCustomer, Pageable pageable);
//    Page<Customer> findAllByContracts_EndDateGreaterThan(String now, Pageable pageable);

    @Query(value = "select * from customer where name like %:nameSearch% and " +
            "email like %:emailSearch%",
            nativeQuery = true)
    Page<Customer> searchCustomer(@Param("nameSearch") String nameSearch, @Param("emailSearch") String emailSearch,
                                  Pageable pageable);

    @Query(value = "select * from customer where name like %:nameSearch% and " +
            "email like %:emailSearch% and customer_type_id = :customerType",
            nativeQuery = true)
    Page<Customer> searchCustomerType(@Param("nameSearch") String nameSearch, @Param("emailSearch") String emailSearch,
                                      @Param("customerType") Integer customerType,Pageable pageable);

}
