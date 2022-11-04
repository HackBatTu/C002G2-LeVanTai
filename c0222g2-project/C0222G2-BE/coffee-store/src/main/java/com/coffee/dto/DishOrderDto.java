package com.coffee.dto;

import com.coffee.model.bill.Bill;
import com.coffee.model.coffee_table.CoffeeTable;
import com.coffee.model.dish.Dish;
import com.coffee.model.employee.Employee;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@RequiredArgsConstructor
public class DishOrderDto {

    @NotNull
    @Min(value = 0, message = "Must greater than 1")
    @Max(value = 5, message = "Must less than 5")
    private Integer quantity;

    @NotNull
    private CoffeeTable coffeeTable;

    @NotNull
    private Bill bill;

    @NotNull
    private Employee employee;

    @NotNull
    private Dish dish;
}
