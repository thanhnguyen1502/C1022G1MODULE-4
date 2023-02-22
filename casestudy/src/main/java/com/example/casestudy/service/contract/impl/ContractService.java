package com.example.casestudy.service.contract.impl;

import com.example.casestudy.model.contract.Contract;
import com.example.casestudy.repository.contract.IContractRepository;
import com.example.casestudy.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository iContractRepository;

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return iContractRepository.findAll(pageable);
    }

    @Override
    public Contract findById(int id) {
        return iContractRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Contract contract) {
        iContractRepository.save(contract);
    }

    @Override
    public void remove(int id) {
        iContractRepository.deleteById(id);
    }

    @Override
    public Page<Contract> findAllByEndDateGreaterThan(String now, Pageable pageable) {
        return iContractRepository.findAllByEndDateGreaterThan(now, pageable);
    }
}
