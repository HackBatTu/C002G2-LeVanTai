package com.link.repository;

import com.link.model.Song;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class SongRepository implements ISongRepository{

    @Override
    public List<Song> findAll() {

        TypedQuery<Song> query = BaseRepository.entityManager.createQuery("select s from Song s" , Song.class);
        return query.getResultList();
    }

    @Override
    public Song findById(Integer id) {
        TypedQuery<Song> query = BaseRepository.entityManager.createQuery("select s from Song s where s.id=:id", Song.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e){
            return null;
        }
//        return BaseRepository.entityManager.find(Song.class, id);
    }

    @Override
    public void save(Song song) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        if(song.getId() != null){
            entityTransaction.begin();
            BaseRepository.entityManager.merge(song);
            entityTransaction.commit();
        }else {
            entityTransaction.begin();
            BaseRepository.entityManager.persist(song);
            entityTransaction.commit();
        }
    }

    @Override
    public void remove(Integer id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        Song song = findById(id);
        if(song!= null){
            entityTransaction.begin();
            BaseRepository.entityManager.remove(song);
            entityTransaction.commit();
        }
    }


}
