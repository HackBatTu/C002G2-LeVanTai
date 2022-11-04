package com.coffee.service.impl;

import com.coffee.repository.IDishTypeRepository;
import com.coffee.service.IDishTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import com.coffee.model.dish.DishType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishTypeService implements IDishTypeService {

    @Autowired
    private IDishTypeRepository iDishTypeRepository;

    /**
     * Created By: HieuCD
     * Date created: 09/08/2022
     * function: get dish list
     * @return Page<DishType> dishPage
     */
    @Override
    public List<DishType> findAllDishType() {
        return iDishTypeRepository.selectAllDishTypeList();
    }

    /**
     * Created By: HieuCD
     * Date created: 09/08/2022
     * function: get dish by dish id
     * @param id
     * @return dish
     */
    @Override
    public DishType findDishTypeById(Integer id) {
        return iDishTypeRepository.selectDishById(id);
    }

    /**
     * @function ( get all List of the dishType )
     * @creator PhucLV
     * @date-create 10/08/2022
     * @return true: list status 200
     */
    @Override
    public List<DishType> getAllListDishType() {
        return iDishTypeRepository.findAllDishType();
    }

}
