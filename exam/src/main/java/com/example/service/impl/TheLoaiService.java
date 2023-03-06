package com.example.service.impl;

import com.example.model.TheLoai;
import com.example.repository.ITheLoaiRepository;
import com.example.service.ITheLoaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheLoaiService implements ITheLoaiService {
    @Autowired
    private ITheLoaiRepository theLoaiRepository;

    @Override
    public List<TheLoai> findAll() {
        return theLoaiRepository.findAll();
    }
}
