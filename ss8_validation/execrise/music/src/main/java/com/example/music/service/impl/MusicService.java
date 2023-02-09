package com.example.music.service.impl;

import com.example.music.model.Music;
import com.example.music.repository.IMusicRepository;
import com.example.music.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MusicService implements IMusicService {
    @Autowired
    private IMusicRepository iMusicRepository;
    @Override
    public List<Music> findAll() {
        return iMusicRepository.findAll();
    }

    @Override
    public void save(Music music) {
    iMusicRepository.save(music);
    }

    @Override
    public void deleteById(Integer id) {
    iMusicRepository.deleteById(id);
    }

    @Override
    public Music findById(Integer id) {
        return iMusicRepository.findById(id).orElse(null);
    }
}
