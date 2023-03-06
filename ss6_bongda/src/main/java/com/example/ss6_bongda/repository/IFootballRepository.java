package com.example.ss6_bongda.repository;

import com.example.ss6_bongda.model.Football;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IFootballRepository extends JpaRepository<Football, Integer> {
    List<Football> findAllByNameContaining(String keySearch);
}
