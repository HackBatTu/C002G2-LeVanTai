package com.coffee.controller;

import com.coffee.dto.DishDto;
import com.coffee.model.dish.Dish;
import com.coffee.service.IDishService;
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
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/dish")
public class DishRestController {

    @Autowired
    private IDishService iDishService;

    /**
    /**
    /**
     * @param dishDto
     * @return dish, status 201
     * @function (create new Dish)
     * @creator PhucLV
     * @date-create 09/08/2022
     */
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping(value = "/create")
    public ResponseEntity<FieldError> createDish(@RequestBody @Valid DishDto dishDto,
                                                 BindingResult bindingResult) {
        dishDto.setDishList(this.iDishService.findAll());
        dishDto.validate(dishDto, bindingResult);

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Dish dish = new Dish();
        BeanUtils.copyProperties(dishDto, dish);
        iDishService.save(dish);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * @param id
     * @return true: id status 200 / false: status 404
     * @function (find the dish of the id)
     * @creator PhucLV
     * @date-create 09/08/2022
     */
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")

    @GetMapping("/{id}")
    public ResponseEntity<Dish> findById(@PathVariable int id) {
        Optional<Dish> dishOptional = iDishService.findById(id);
        if (!dishOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(dishOptional.get(), HttpStatus.OK);
    }

    /**
     * @param id //     * @param dishDto
     * @return true: dish, status 200 / false: status 404
     * @function (edit the value of the dish)
     * @creator PhucLV
     * @date-create 09/08/2022
     */
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PatchMapping("/edit/{id}")
    public ResponseEntity<FieldError> updateDish(@PathVariable int id, @RequestBody @Valid DishDto dishDto, BindingResult bindingResult) {
        Optional<Dish> dishOptional = iDishService.findById(id);
        if (!dishOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.UPGRADE_REQUIRED);
        }
        dishDto.setId(dishOptional.get().getId());
        Dish dish = new Dish();
        BeanUtils.copyProperties(dishDto, dish);

        iDishService.editDish(dish);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Created by: HieuCD
     * Date created: 09/08/2022
     * function: show dish page
     *
     * @param pageable
     * @return HTTP status  200(OK) : return Page<Dish> dishPage
     * HTTP status  204(NO_CONTENT): return dishPage is empty
     */
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/getDishPage")
    public ResponseEntity<Page<Dish>> getAllDish(@PageableDefault(4) Pageable pageable) {
        Page<Dish> dishPage = this.iDishService.findAllDish(pageable);
        if (dishPage.isEmpty()) {
            return new ResponseEntity<>(dishPage, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(dishPage, HttpStatus.OK);
        }
    }

    /**
     * Created by: HieuCD
     * Date created: 09/08/2022
     * function: search dish
     *
     * @param pageable
     * @param dishName
     * @param dishCode
     * @param dishPrice
     * @param dishTypeId
     * @return * HTTP status  200(OK) : return Page<Dish> dishPage
     * * HTTP status  204(NO_CONTENT): return dishPage is empty
     */
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/searchDish")
    public ResponseEntity<Page<Dish>> getAllDish(@PageableDefault(10) Pageable pageable,
                                                 Optional<String> dishName,
                                                 Optional<String> dishCode,
                                                 Optional<String> dishPrice,
                                                 Optional<String> dishTypeId) {
        String name = dishName.orElse("");
        String code = dishCode.orElse("");
        String price = dishPrice.orElse("");
        String typeId = dishTypeId.orElse("");
        if (typeId.equals("")) {
            typeId = "%" + typeId + "%";
        }

        if (name.equals("null")) {
            name = "";
        }
        if (code.equals("null")) {
            code = "";
        }
        if (price.equals("null")) {
            price = "";
        }

        Page<Dish> dishPage = this.iDishService.searchDish(name, code, price, typeId, pageable);
        if (dishPage.isEmpty()) {
            return new ResponseEntity<>(dishPage, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(dishPage, HttpStatus.OK);
        }
    }

    /**
     * Created by: HieuCD
     * Date created: 09/08/2022
     * function: get dish by dish
     *
     * @param id
     * @return HTTP status  204(NO_CONTENT) : id = null
     * HTTP status  200(OK) : return a dish
     */
//    @PreAuthorize("isAuthenticated()")
    @GetMapping("/findById/{id}")
    public ResponseEntity<Dish> findById(@PathVariable Integer id) {
        Dish dish = this.iDishService.findDishById(id);
        if (dish == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(dish, HttpStatus.OK);
    }

    /**
     * Created by: HieuCD
     * Date created: 09/08/2022
     * function: delete dish by dish
     *
     * @param id
     * @return HTTP status  204(NO_CONTENT) : id = null
     * HTTP status  200(OK) : deleted
     */
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PatchMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDish(@PathVariable Integer id) {
        this.iDishService.deleteDish(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Created by: BinhPX
     * Date created: 14/08/2022
     * function: get dish from dish type
     *
     * @param id
     * @return HTTP status  204(NO_CONTENT) : id = null
     * HTTP status  200(OK) : deleted
     */
//    @PreAuthorize("isAuthenticated()")
    @GetMapping("/getDishFindIdDishType/{id}")
    public ResponseEntity<Page<Dish>> getAllDishFindIdDishType(@PathVariable Integer id,
                                                               @PageableDefault(4) Pageable pageable,
                                                               @RequestParam("page") Optional<Integer> page) {
        Page<Dish> dishPage = this.iDishService.getDishByDishType(id, pageable);
        if (dishPage.isEmpty()) {
            return new ResponseEntity<>(dishPage, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(dishPage, HttpStatus.OK);
        }
    }
}
