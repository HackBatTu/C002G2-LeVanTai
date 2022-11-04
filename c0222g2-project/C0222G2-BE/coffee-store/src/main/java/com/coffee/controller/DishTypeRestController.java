package com.coffee.controller;

import com.coffee.model.dish.DishType;
import com.coffee.service.IDishTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@CrossOrigin
@RequestMapping("/dishType")
public class DishTypeRestController {

    @Autowired
    private IDishTypeService iDishTypeService;

    /**
     * Created by: HieuCD
     * Date created: 17/08/2022
     * function: get type of dish List
     *
     * @return HTTP status  200(OK) : return Page<DishType> dishTypePage
     * HTTP status  204(NO_CONTENT): return dishTypePage is empty
     */
    @GetMapping("/getDishTypeList")
    public ResponseEntity<List<DishType>> getAllProductBlock() {
        List<DishType> productBlockList = this.iDishTypeService.findAllDishType();
        if (productBlockList.isEmpty()) {
            return new ResponseEntity<>(productBlockList, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(productBlockList, HttpStatus.OK);
        }
    }

    /**
     * Created by: HieuCD
     * Date created: 10/08/2022
     * function: get type of dish Page
     *
     * @param id
     * @return * HTTP status  204(NO_CONTENT) : id = null
     * * HTTP status  200(OK) : return a dishType
     */
    @GetMapping("/findById/{id}")
    public ResponseEntity<DishType> findById(@PathVariable Integer id) {
        DishType dishType = this.iDishTypeService.findDishTypeById(id);
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(dishType, HttpStatus.OK);
    }

    /**
     * @function ( get all List of the dishType )
     * @creator PhucLV
     * @date-create 10/08/2022
     * @return true: list   status 200
     */
    @GetMapping("/list_dish_type")
    public ResponseEntity<List<DishType>> getAllDishTypeList() {
        List<DishType> dishTypeList = this.iDishTypeService.getAllListDishType();
        return new ResponseEntity<>(dishTypeList, HttpStatus.OK);
    }

}
