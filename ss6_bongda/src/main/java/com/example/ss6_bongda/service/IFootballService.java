package com.example.ss6_bongda.service;

import com.example.ss6_bongda.model.Football;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFootballService {
    void remove(Integer id);
    void save(Football football);
    Page<Football> findAllByNameAllBirthday(String keySearch, Pageable pageable);
    Football findById(Integer id);
}
