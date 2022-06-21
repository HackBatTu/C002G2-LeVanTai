package com.link.service;

import com.link.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();

    Song findById(Integer id);

    void save(Song song);

    void remove(Integer id);


}
