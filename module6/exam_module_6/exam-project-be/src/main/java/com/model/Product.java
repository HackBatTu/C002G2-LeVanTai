package com.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String codeProduct;

    private String name;

    private Double unitPrice;

    @Column(columnDefinition = "date")
    private Date dateCheckIn;

    @Column(columnDefinition = "bit(1) default 0")
    private Boolean statusProduct;

    private String origin;

    private Boolean statusDrink;

    private Boolean statusFood;

    private String author;

    private String bookType;

    @Column(columnDefinition = "date")
    private Date dateIn;

    @ManyToOne
    @JoinColumn(name = "product_type_id",referencedColumnName = "id")
    private ProductType productType;

    @ManyToOne
    @JoinColumn(name = "employee_id",referencedColumnName = "id")
    private Employee employee;

    @JsonIgnore
    @OneToMany
    private List<Order> orderList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Product product = (Product) o;
        return id != null && Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
