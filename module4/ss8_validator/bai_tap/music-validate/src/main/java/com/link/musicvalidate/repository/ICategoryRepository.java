package com.link.musicvalidate.repository;

import com.link.musicvalidate.model.Category;
import com.link.musicvalidate.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {

    @Query(value = " select * from category",nativeQuery = true)
    List<Category> findAll();
}
