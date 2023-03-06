package com.example.ss6_bongda.service;

import com.example.ss6_bongda.model.Football;

import java.util.List;

public interface IFootballService {
    void remove(Integer id);
    void save(Football football);
    List<Football> findAllByNameAllBirthday(String keySearch);
    Football findById(Integer id);
}
