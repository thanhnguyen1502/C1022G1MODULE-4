package com.example.casestudy.service.facility.impl;

import com.example.casestudy.model.facility.RentType;
import com.example.casestudy.repository.facility.IRentTypeRepository;
import com.example.casestudy.service.facility.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeService implements IRentTypeService {
    @Autowired
    private IRentTypeRepository rentTypeRepository;
    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }
}
