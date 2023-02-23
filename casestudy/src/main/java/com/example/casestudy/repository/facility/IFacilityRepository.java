package com.example.casestudy.repository.facility;

import com.example.casestudy.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IFacilityRepository extends JpaRepository<Facility, Integer> {
    Page<Facility> findAllByNameContaining(String nameFacility, Pageable pageable);

//    @Query(value = "select * from facility where name like %:nameSearch% and facility_type_id = :facilityType" , nativeQuery = true)

    @Query(value = "SELECT f.*, ft.id AS id_facility FROM facility f  " +
            "JOIN facility_type ft ON f.facility_type_id = ft.id  " +
            "WHERE f.name LIKE %:nameSearch% " +
            "AND ft.id = :facilityType" , nativeQuery = true)


    Page<Facility> searchFacilityType(@Param("nameSearch") String nameSearch, @Param("facilityType") Integer facilityType, Pageable pageable);

}
