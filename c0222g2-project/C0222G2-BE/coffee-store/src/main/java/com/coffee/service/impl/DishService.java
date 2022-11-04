package com.coffee.service.impl;

import com.coffee.model.dish.Dish;
import com.coffee.repository.IDishRepository;
import com.coffee.service.IDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DishService implements IDishService {
    @Autowired
    private IDishRepository iDishRepository;

    /**
     * @function ( create new Dish)
     * @param dish
     * @return dish, status 201
     * @creator PhucLV
     * @date-create 09/08/2022
     */
    @Override
    public void save(Dish dish) {
        iDishRepository.saveDish(dish);
    }

    /**
     * @function ( find the dish of the id )
     * @creator PhucLV
     * @date-create 09/08/2022
     * @param id
     * @return  id
     */
    @Override
    public Optional<Dish> findById(int id) {
        return iDishRepository.findByIdDish(id);
    }

    /**
     * @function ( edit the value of the dish)
     * @creator PhucLV
     * @date-create 09/08/2022
     * @param dish
     * @return dish
     */
    @Override
    public void editDish( Dish dish) {
        iDishRepository.editDish(dish);
    }

    /**
     * Created By: HieuCD
     * Date created: 09/08/2022
     * function: get dish page
     *
     * @param pageable
     * @return Page<Dish> dishPage
     */
    @Override
    public Page<Dish> findAllDish(Pageable pageable) {
        return iDishRepository.selectAllDishPage(pageable);
    }

    /**
     * Created By: HieuCD
     * Date created: 09/08/2022
     * function: get dish by dish id
     *
     * @param id
     * @return dish
     */
    @Override
    public Dish findDishById(Integer id) {
        return iDishRepository.selectDishById(id);
    }

    /**
     * Created By: HieuCD
     * Date created: 09/08/2022
     * function: delete dish by dish id
     *
     * @param id
     */
    @Override
    public void deleteDish(Integer id) {
        iDishRepository.deleteDishById(id);
    }

    /**
     * Created By: HieuCD
     * Date created: 10/08/2022
     * function: search dish by dish name,code
     *
     * @param name
     * @param code
     * @param price
     * @param dishType
     * @param pageable
     * @return dishPage (search)
     */
    @Override
    public Page<Dish> searchDish(String name, String code, String price, String dishType, Pageable pageable) {
        return iDishRepository.searchDishPage("%" + name + "%", "%" + code + "%", "%" + price + "%", dishType, pageable);
    }

    /**
     * Created By: BinhPX
     * Date created: 14/08/2022
     * function: get Dish list
     *
     * @param id of dish type
     * @param pageable
     * @return dishPage
     */
    @Override
    public Page<Dish> getDishByDishType(int id, Pageable pageable) {
        return iDishRepository.findAllDishFindByeId(id, pageable);
    }

    /**
     * @function ( Get All dishList)
     * @creator PhucLV
     * @date-create 17/08/2022
     *
     * @return dish
     */
    @Override
    public List<Dish> findAll() {
        return iDishRepository.findAll();
    }

}
