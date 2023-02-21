package com.example.casestudy.service.facility;

import com.example.casestudy.model.facility.Facility;
import com.example.casestudy.repository.facility.IFacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityService implements IFacilityService{
    @Autowired
    private IFacilityRepository facilityRepository;

    @Override
    public Page<Facility> findAllByNameContaining(String nameFacility, Pageable pageable) {
        return facilityRepository.findAllByNameContaining(nameFacility,pageable);
    }

    @Override
    public List<Facility> showFacilityList() {
        return facilityRepository.findAll();
    }

    @Override
    public void save(Facility facility) {
        facilityRepository.save(facility);
    }

    @Override
    public Facility findById(int id) {
        return facilityRepository.getById(id);
    }

    @Override
    public void deleteById(int id) {
        facilityRepository.deleteById(id);
    }
}
