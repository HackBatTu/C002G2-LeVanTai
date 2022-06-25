package com.link.musicvalidate.service;

import com.link.musicvalidate.model.Category;
import com.link.musicvalidate.model.Music;

import java.util.List;

public interface IMusicService {
    List<Music> findAll();

    void save(Music music);

    Music findById(int id);

    List<Category> getAllCategory();
}
