package com.example.music.service;

import com.example.music.model.Music;

import java.util.List;

public interface IMusicService {
    List<Music> findAll();
    void save(Music music);
    void deleteById(Integer id);
    Music findById(Integer id);
}
