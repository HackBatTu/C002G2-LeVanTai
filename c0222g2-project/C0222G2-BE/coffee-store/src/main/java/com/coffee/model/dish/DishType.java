package com.coffee.model.dish;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class DishType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String code;

    private String name;

    @Column(columnDefinition = "bit(1) default 0")
    private Boolean isDeleted;

    @OneToMany(mappedBy = "dishType")
    @JsonIgnore
    private List<Dish> dishes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        DishType dishType = (DishType) o;
        return id != null && Objects.equals(id, dishType.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
