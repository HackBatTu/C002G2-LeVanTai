package com.link.booklibrary.repository;

import com.link.booklibrary.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ILibraryRepository extends JpaRepository<Library, Integer> {
    @Modifying
    @Transactional
    @Query(value = " UPDATE library SET quantity = quantity - 1 WHERE (id = :id);  " ,nativeQuery = true)
    void setQuantity(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = " UPDATE library SET quantity = quantity + 1 WHERE (id = :id);  " ,nativeQuery = true)
    void updateQuantity(@Param("id") Integer id);
}
