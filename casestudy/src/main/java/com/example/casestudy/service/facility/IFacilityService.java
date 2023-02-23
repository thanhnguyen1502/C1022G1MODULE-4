package com.example.casestudy.service.facility;

import com.example.casestudy.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacilityService {
    Page<Facility> findAllByNameContaining(String nameFacility, Pageable pageable);
    Page<Facility> searchFacilityType( String nameSearch, Integer facilityType, Pageable pageable);
    List<Facility> showFacilityList();
    void save(Facility facility);
    Facility findById(int id);
    void deleteById(int id);
}
