package com.coffee.service;
import com.coffee.model.dish.DishType;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IDishTypeService {

    List<DishType> findAllDishType();

    DishType findDishTypeById(Integer id);

    List<DishType> getAllListDishType();
}
