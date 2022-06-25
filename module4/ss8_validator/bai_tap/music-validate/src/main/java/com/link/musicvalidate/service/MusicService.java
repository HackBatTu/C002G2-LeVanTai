package com.link.musicvalidate.service;

import com.link.musicvalidate.model.Category;
import com.link.musicvalidate.model.Music;
import com.link.musicvalidate.repository.ICategoryRepository;
import com.link.musicvalidate.repository.IMusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService implements IMusicService{
    @Autowired
    private IMusicRepository iMusicRepository;

    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Override
    public List<Music> findAll() {
        return iMusicRepository.findAll();
    }

    @Override
    public void save(Music music) {
        iMusicRepository.save(music);
    }

    @Override
    public Music findById(int id) {
        return iMusicRepository.findById(id).orElse(null);
    }

    @Override
    public List<Category> getAllCategory() {
        return iCategoryRepository.findAll();
    }
}
