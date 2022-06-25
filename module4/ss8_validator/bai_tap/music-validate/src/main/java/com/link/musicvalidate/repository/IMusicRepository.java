package com.link.musicvalidate.repository;

import com.link.musicvalidate.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IMusicRepository extends JpaRepository<Music, Integer> {

//    @Query(value = " select * from music",nativeQuery = true)
//    List<Music> findAll();
//
//    @Modifying
//    @Transactional
//    @Query(value = " select * from music m where m.id=:id",nativeQuery = true)
//    Music findById(@Param("id") int id);
}
