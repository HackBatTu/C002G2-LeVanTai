package com.phuong.repository;

import com.phuong.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {

    @Query(value = " select * from category where is_deleted = 0 ", nativeQuery = true)
    Page<Category> getAllCategory(Pageable pageable);

    @Query(value = " select * from category where is_deleted = 0 " +
            " order by discount_percent desc " +
            " limit 2 ", nativeQuery = true)
    List<Category> getCategoryDiscount();

    @Query(value = " select * from category where is_deleted = 0 ", nativeQuery = true)
    List<Category> getAllCategoryList();
}
