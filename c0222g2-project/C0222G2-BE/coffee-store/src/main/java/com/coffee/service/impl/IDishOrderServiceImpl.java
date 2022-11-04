package com.coffee.service.impl;

import com.coffee.dto.DishMostOrderDTO;
import com.coffee.dto.DishNewestDTO;
import com.coffee.model.dish_order.DishOrder;
import com.coffee.repository.IDishOrderRepository;
import com.coffee.service.IDishOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IDishOrderServiceImpl implements IDishOrderService {

    @Autowired
    private IDishOrderRepository iDishOrderRepository;

    @Override
    public List<DishMostOrderDTO> get5DishMostOrderDTO() {
        return iDishOrderRepository.get5DishMostOrderDTO();
    }

    @Override
    public List<DishNewestDTO> get5DishNewestDTO() {
        return iDishOrderRepository.get5DishNewestDTO();
    }

    @Override
    public Page<DishOrder> getAllOrder(Pageable pageable) {
        return iDishOrderRepository.getAllOrder(pageable);
    }

    @Override
    public void createOrder(DishOrder orderDish) {
        iDishOrderRepository.createOrder(orderDish);
    }

    @Override
    public List<DishOrder> getOrderHaveCode(int param) {
        return iDishOrderRepository.getOrderHaveCode(param);
    }

    @Override
    public void deleteDishOrder(String param) {
        iDishOrderRepository.deleteOrder(param);
    }
}
