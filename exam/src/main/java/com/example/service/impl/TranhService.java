package com.example.service.impl;

import com.example.model.Tranh;
import com.example.repository.ITranhRepository;
import com.example.service.ITranhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TranhService implements ITranhService {

    @Autowired
    private ITranhRepository tranhRepository;

    @Override
    public void remove(Integer id) {
        tranhRepository.deleteById(id);
    }

    @Override
    public void save(Tranh tranh) {
        tranhRepository.save(tranh);
    }

    @Override
    public List<Tranh> findAllByName(String timTacPham) {
        return tranhRepository.findAllByTenTacPhamContaining(timTacPham);
    }

    @Override
    public Tranh findByid(Integer id) {
        return tranhRepository.getById(id);
    }
}
