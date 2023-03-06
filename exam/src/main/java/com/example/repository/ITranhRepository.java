package com.example.repository;

import com.example.model.Tranh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ITranhRepository extends JpaRepository<Tranh, Integer>{
    List<Tranh> findAllByTenTacPhamContaining(@Param("timTacPham") String timTacPham);
}
