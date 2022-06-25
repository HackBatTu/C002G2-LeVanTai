package com.link.repository;

import com.link.model.Blogger;
import com.link.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer> {

    @Query(value = " select * from category ", nativeQuery = true)
    List<Category> getAllCategory();

//    @Modifying
//    @Transactional
//    @Query(value = " delete from category b where b.id = :id ", nativeQuery = true)
//    void delete(@Param("id") int id);
//
//    @Query(value = " select * from category b where b.id = :id", nativeQuery = true)
//    Blogger findByCate(@Param("id") int id);
}
