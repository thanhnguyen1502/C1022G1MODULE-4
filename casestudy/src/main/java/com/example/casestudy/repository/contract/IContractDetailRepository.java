package com.example.casestudy.repository.contract;

import com.example.casestudy.model.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IContractDetailRepository extends JpaRepository<ContractDetail,Integer> {
    List<ContractDetail> findAllByContractId_Id(int id);

}
