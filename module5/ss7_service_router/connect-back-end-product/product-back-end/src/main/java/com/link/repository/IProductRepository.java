package com.link.repository;

import com.link.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "select product.* from product join category on category.id = product.category_id " +
            " where product.name like :searchName ", nativeQuery = true ,
    countQuery = "select count(*) from (select product.* from product join category on category.id = product.category_id " +
            " where product.name like :searchName) temp_table ")
    Page<Product> findAllProduct(Pageable pageable, String searchName);
}
