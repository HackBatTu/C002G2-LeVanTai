package com.coffee.repository;

import com.coffee.model.dish.Dish;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface IDishRepository extends JpaRepository<Dish, Integer> {
//    @Query(value = "select id,code,name,creation_date,image,is_deleted,price,dish_type_id from dish", nativeQuery = true)
//    List<Dish> findAllDish();

    @Transactional
    @Modifying
    @Query(value = " INSERT INTO dish (`dish_type_id`, image, `name`, code, price, creation_date) " +
            " VALUES (:#{#dish.dishType.id}, :#{#dish.image}, :#{#dish.name}, :#{#dish.code}, " +
            " :#{#dish.price}, :#{#dish.creationDate}); ", nativeQuery = true)
    void saveDish(Dish dish);

    @Query(value = "select * from dish where id = :id", nativeQuery = true)
    Optional<Dish> findByIdDish(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = " update dish set `name`= :#{#dish.name}, image = :#{#dish.image}, code = :#{#dish.code},  price = :#{#dish.price}, creation_date = :#{#dish.creationDate}, is_deleted = :#{#dish.isDeleted}, dish_type_id = :#{#dish.dishType.id} where id= :#{#dish.id}",
            nativeQuery = true)
    void editDish(Dish dish);

    @Query(value = " SELECT id,`code`,creation_date,image,is_deleted,`name`,price,dish_type_id FROM dish where is_deleted = 0 ",
            nativeQuery = true, countQuery = " select count(*) from ( SELECT id,`code`,creation_date,image,is_deleted,`name`,price,dish_type_id FROM dish where is_deleted = 0 ) temp_table ")
    Page<Dish> selectAllDishPage(Pageable pageable);

    @Query(value = " select d.id, d.code, d.creation_date, d.image, d.is_deleted, d.name, d.price, d.dish_type_id from dish d " +
            " join dish_type dt on dt.id = d.dish_type_id " +
            " where d.name like :name and d.code like :code and d.price like :price and d.dish_type_id like :dishType and d.is_deleted = 0 ", nativeQuery = true,
            countQuery = " select count(*) from ( select d.id, d.code, d.creation_date, d.image, d.is_deleted, d.name, d.price, d.dish_type_id from dish d " +
                    " join dish_type dt on dt.id = d.dish_type_id " +
                    " where d.name like :name and d.code like :code and d.price like :price and d.dish_type_id like :dishType and d.is_deleted = 0 ) temp_table ")
    Page<Dish> searchDishPage(@Param("name") String name, @Param("code") String code, @Param("price") String price, @Param("dishType") String dishType, Pageable pageable);


    @Query(value = "SELECT id,`code`,creation_date,image,is_deleted,`name`,price,dish_type_id  from dish d where d.id =:dishId", nativeQuery = true)
    Dish selectDishById(@Param("dishId") Integer id);

    @Transactional
    @Modifying
    @Query(value = " update dish d set is_deleted = 1 where  d.id =:dishId and d.is_deleted = 0", nativeQuery = true)
    int deleteDishById(@Param("dishId") Integer id);

    @Query(value = "select d.* from dish d join dish_type dt on dt.id = d.dish_type_id where d.dish_type_id = :id ", nativeQuery = true,
            countQuery = " select count(*) from (select d.* from dish d join dish_type dt on dt.id = d.dish_type_id where d.dish_type_id= :id ) temp_table")
    Page<Dish> findAllDishFindByeId(@Param("id") Integer id, Pageable pageable);
}
