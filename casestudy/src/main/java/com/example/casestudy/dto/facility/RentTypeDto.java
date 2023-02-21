package com.example.casestudy.dto.facility;

import java.util.List;

public class RentTypeDto {
    private int id;

    private String name;

    private List<FacilityDto> facilities;

    public RentTypeDto() {
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

    public List<FacilityDto> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<FacilityDto> facilities) {
        this.facilities = facilities;
    }
}
