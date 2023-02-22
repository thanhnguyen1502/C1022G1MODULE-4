package com.example.casestudy.repository.contract;

import com.example.casestudy.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractRepository extends JpaRepository<Contract, Integer> {
    Page<Contract> findAllByEndDateGreaterThan(String now, Pageable pageable);
}
