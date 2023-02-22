package com.example.casestudy.service.contract.impl;

import com.example.casestudy.model.contract.ContractDetail;
import com.example.casestudy.repository.contract.IContractDetailRepository;
import com.example.casestudy.service.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    private IContractDetailRepository iContractDetailRepository;


    @Override
    public List<ContractDetail> findAllByContractId(int id) {
        return iContractDetailRepository.findAllByContractId_Id(id);
    }
}
