package com.link.service;

import com.link.model.Song;
import com.link.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class SongService implements ISongService{
    @Autowired
    private ISongRepository iSongRepository ;


    @Override
    public List<Song> findAll() {
        return iSongRepository.findAll();
    }

    @Override
    public Song findById(Integer id) {
        return iSongRepository.findById(id);
    }

    @Override
    public void save(Song song) {
        iSongRepository.save(song);
    }

    @Override
    public void remove(Integer id) {
        iSongRepository.remove(id);
    }

    @Override
    public void update(Song song) {
        iSongRepository.update(song);
    }


}
