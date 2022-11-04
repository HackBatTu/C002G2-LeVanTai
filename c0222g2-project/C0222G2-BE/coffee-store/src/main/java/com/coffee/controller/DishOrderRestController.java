package com.coffee.controller;

import com.coffee.dto.DishMostOrderDTO;
import com.coffee.dto.DishNewestDTO;
import com.coffee.dto.DishOrderDto;
import com.coffee.model.dish_order.DishOrder;
import com.coffee.service.IDishOrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/dish-order")
public class DishOrderRestController {

    @Autowired
    private IDishOrderService iDishOrderService;

    /**
     * Created by: BaoTQ
     * Date create: 09/08/2022
     * function: display 5 dish most order
     */
    @GetMapping("/most-order")
    public ResponseEntity<List<DishMostOrderDTO>> getListDishMostOrder() {
        List<DishMostOrderDTO> mostOrderList = iDishOrderService.get5DishMostOrderDTO();
        if (mostOrderList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(mostOrderList, HttpStatus.OK);
    }

    /**
     * Author: BinhPX
     * Date created: 09/08/2022
     * This function create new order, @param dishOrderDto, @return
     **/
//    @PreAuthorize("isAuthenticated()")
    @PostMapping("/create-dishOrder")
    public ResponseEntity<List<FieldError>> createOrder(@Valid @RequestBody DishOrderDto dishOrderDto, BindingResult bindingResult) {
        DishOrder dishOrder = new DishOrder();
        int numberCode = (int) (Math.random() * 9999);
        dishOrder.setCode("OD-" + numberCode);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        BeanUtils.copyProperties(dishOrderDto, dishOrder);
        iDishOrderService.createOrder(dishOrder);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Author: BinhPX
     * Date created: 10/08/2022
     * This function get list, @param is pageable and page, size, @return status ok if size greater than 0
     * and return status bad gateway if size equal 0
     **/
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_STAFF')")
    @GetMapping("/get-dish-list")
    public ResponseEntity<Page<DishOrder>> getAllOrder(@PageableDefault(4) Pageable pageable,
                                                       @RequestParam("page") Optional<Integer> page,
                                                       @RequestParam("size") Optional<Integer> size) {
        Page<DishOrder> dishOrders = iDishOrderService.getAllOrder(pageable);
        if (dishOrders.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(dishOrders, HttpStatus.OK);
    }

    /**
     * Author: BinhPX
     * Date created: 10/08/2022
     * This function get order have code is, @param is a code, @return status ok if size greater than 0
     * and return status bad gateway if size equal 0
     **/
    @GetMapping("/get-order-have-code/{code}")
    public ResponseEntity<List<DishOrder>> getOrderHaveCode(@PathVariable int code) {
        List<DishOrder> dishOrders = iDishOrderService.getOrderHaveCode(code);
        if (dishOrders.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(dishOrders, HttpStatus.OK);
        }
    }

    /**
     * Created by: BaoTQ
     * Date create: 09/08/2022
     * function: display 5 dish newest
     */
    @GetMapping("/newest")
    public ResponseEntity<List<DishNewestDTO>> getListDishNewest() {
        List<DishNewestDTO> newestList = iDishOrderService.get5DishNewestDTO();
        if (newestList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(newestList, HttpStatus.OK);
    }

    /**
     * Author: BinhPX
     * Date created: 12/08/2022
     * This function delete order have @param is a code, @return status ok if deleted
     **/
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_STAFF')")
    @DeleteMapping("/delete-code/{code}")
    public ResponseEntity<List<FieldError>> deleteOrderHaveCode(@PathVariable String code) {
        if (code == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.iDishOrderService.deleteDishOrder(code);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
