package com.example.casestudy.model.facility;


import javax.persistence.*;
import java.util.List;

@Entity
public class FacilityType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "facilityType")
    private List<Facility> facilities;

    public FacilityType() {
    }

    public FacilityType(int id, String name, List<Facility> facilities) {
        this.id = id;
        this.name = name;
        this.facilities = facilities;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<Facility> facilities) {
        this.facilities = facilities;
    }
}