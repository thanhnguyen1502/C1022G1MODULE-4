package com.example.casestudy.service.contract.impl;

import com.example.casestudy.model.contract.AttachFacility;
import com.example.casestudy.repository.contract.IAttachFacilityRepository;
import com.example.casestudy.service.contract.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachFacilityService implements IAttachFacilityService {
    @Autowired
    private IAttachFacilityRepository iAttachFacilityRepository;
    @Override
    public List<AttachFacility> findAll() {
        return iAttachFacilityRepository.findAll();
    }
}
