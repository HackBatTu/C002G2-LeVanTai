package com.repository;

import com.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


public interface IProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "select * from product join product_type on product.product_type_id = product_type.id where status_product = 0 ",
    nativeQuery = true , countQuery = "select count(*) from (select * from product join product_type on product.product_type_id = product_type.id where status_product = 0) temp_table")
    Page<Product> findAllProduct(Pageable pageable);

    @Modifying
    @Transactional
    @Query(value = "update product p set status_product = 1 where p.id = :id",nativeQuery = true)
    void deleteProduct(Integer id);
}
