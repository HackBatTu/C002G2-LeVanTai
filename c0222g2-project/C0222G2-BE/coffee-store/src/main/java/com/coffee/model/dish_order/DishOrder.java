package com.coffee.model.dish_order;

import com.coffee.model.bill.Bill;
import com.coffee.model.coffee_table.CoffeeTable;
import com.coffee.model.dish.Dish;
import com.coffee.model.employee.Employee;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class DishOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String code;

    private Integer quantity;

    @Column(columnDefinition = "bit(1) default 0")
    private Boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "coffee_table_id", referencedColumnName = "id")
    private CoffeeTable coffeeTable;

    @ManyToOne
    @JoinColumn(name = "bill_id", referencedColumnName = "id")
    private Bill bill;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "dish_id", referencedColumnName = "id")
    private Dish dish;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        DishOrder dishOrder = (DishOrder) o;
        return id != null && Objects.equals(id, dishOrder.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
