package com.example.service;

import com.example.model.Tranh;
import com.example.service.impl.TranhService;

import java.util.List;

public interface ITranhService {
    void remove(Integer id);

    void save(Tranh tranh);

    List<Tranh> findAllByName(String timTacPham);

    Tranh findByid(Integer id);
}
