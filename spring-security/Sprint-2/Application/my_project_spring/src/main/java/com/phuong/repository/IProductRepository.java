package com.phuong.repository;

import com.phuong.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = " SELECT * FROM product where is_deleted = 0 order by release_time desc limit 8 ", nativeQuery = true)
    List<Product> getNewProducts();

    @Query(value = " select p.* from product p " +
            " join category c on c.id = p.category_id" +
            " where c.id = :id and p.is_deleted = 0 and c.is_deleted = 0 ", nativeQuery = true)
    List<Product> findByCategoryId(@Param("id") Integer id);

    @Query(value = " select p.* from product p " +
            " left join category c on c.id = p.category_id " +
            " where category_id like :id and p.name like :productName " +
            " and p.price between :beginPrice and :endPrice and origin like :originName " +
            " and p.is_deleted = 0 ", nativeQuery = true,
            countQuery = " select count(*) from (select p.* from product p " +
            " left join category c on c.id = p.category_id " +
            " where category_id like :id and p.name like :productName " +
            " and p.price between :beginPrice and :endPrice and origin like :originName " +
            " and p.is_deleted = 0) temp ")
    Page<Product> findAll(Pageable pageable,
                          @Param("id") String id,
                          @Param("productName") String productName,
                          @Param("beginPrice") Double beginPrice, @Param("endPrice") Double endPrice,
                          @Param("originName") String originName);

    @Transactional
    @Modifying
    @Query(value = " update product set is_deleted = 1 where id = :id ", nativeQuery = true)
    void deleteProduct(@Param("id") String id);

    @Query(value = " select * from product where is_deleted = 0 ", nativeQuery = true)
    List<Product> findAllListProduct();

    @Modifying
    @Transactional
    @Query(value = " UPDATE `product` SET `quantity` = (`quantity` - :quantity) WHERE (`id` = :id) ", nativeQuery = true)
    void updateQuantity(@Param("quantity") Integer quantity,@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = " UPDATE `product` SET `is_deleted` = 1 WHERE (`id` = :id) ", nativeQuery = true)
    void updateIsDeleted(@Param("id") Integer id);
}
