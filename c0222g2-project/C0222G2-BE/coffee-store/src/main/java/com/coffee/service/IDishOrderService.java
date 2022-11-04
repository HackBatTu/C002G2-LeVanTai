package com.coffee.service;

import com.coffee.dto.DishMostOrderDTO;
import com.coffee.dto.DishNewestDTO;
import com.coffee.model.dish_order.DishOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IDishOrderService {

    /**
     * Created by: BaoTQ
     * Date create: 09/08/2022
     * function: get 5 dish most order
     */
    List<DishMostOrderDTO> get5DishMostOrderDTO();

    /**
     * Created by: BaoTQ
     * Date create: 09/08/2022
     * function: get 5 dish newest
     */
    List<DishNewestDTO> get5DishNewestDTO();

     /**
     *   Author: BinhPX
     *   Date created: 09/08/2022
     *   This function will return all data can get, @param pageable, @return
     **/
    Page<DishOrder> getAllOrder(Pageable pageable);

    /**
     *   Author: BinhPX
     *   Date created: 09/08/2022
     *   This function create new order menu, @param orderDish, @return
     **/
    void createOrder(DishOrder orderDish);

    /**
     *   Author: BinhPX
     *   Date created: 09/08/2022
     *   This function return order menu could find, @param tableId, @return list DishOrder
     **/
    List<DishOrder> getOrderHaveCode(int param);


    /**
     *   Author: BinhPX
     *   Date created: 12/08/2022
     *   This function use to update status of order
     **/
    void deleteDishOrder(String param);
}
