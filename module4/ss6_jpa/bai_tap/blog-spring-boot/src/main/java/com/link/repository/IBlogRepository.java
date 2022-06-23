package com.link.repository;

import com.link.model.Blogger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blogger, Integer> {

    @Query(value = " select * from blogger ", nativeQuery = true)
    List<Blogger> getAllBlog();

    @Modifying
    @Transactional

    @Query(value = " delete from blogger b where b.id = :id ", nativeQuery = true)
    void deleteBlog(@Param("id") int id);

    @Query(value = " select * from blogger b where b.id = :id", nativeQuery = true)
    Blogger getBlogger(@Param("id") int id);



}
