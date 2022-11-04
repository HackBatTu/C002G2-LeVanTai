package com.coffee.service;

import com.coffee.model.dish.Dish;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IDishService {
    Page<Dish> findAllDish(Pageable pageable);

    Dish findDishById(Integer id);

    void deleteDish(Integer id);

    Page<Dish> searchDish(String name, String code, String price, String dishTypeId, Pageable pageable);

    void save(Dish dish);

    Optional<Dish> findById(int id);

    void editDish(Dish dish);

    Page<Dish> getDishByDishType(int id, Pageable pageable);

    List<Dish> findAll();
}
