package com.example.casestudy.repository.facility;

import com.example.casestudy.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IFacilityRepository extends JpaRepository<Facility, Integer> {
//    Page<Facility> findAllByNameContaining(String nameFacility, Pageable pageable);

    @Query(value = "select * from facility where name like %:nameSearch% and facility_type_id = customer_type", nativeQuery = true)
    Page<Facility> searchFacilityType(@Param("nameSearch") String nameSearch, @Param("facilityType") Integer facilityType, Pageable pageable);
}
