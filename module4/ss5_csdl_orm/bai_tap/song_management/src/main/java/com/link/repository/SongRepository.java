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
        entityTransaction.begin();
        try {
            BaseRepository.entityManager.persist(song);
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        }
    }

    @Override
    public void remove(Integer id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        try {
            BaseRepository.entityManager.remove(BaseRepository.entityManager.find(Song.class,id));
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        }
    }

    @Override
    public void update(Song song) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        try {
            BaseRepository.entityManager.merge(song);
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        }
    }


}
