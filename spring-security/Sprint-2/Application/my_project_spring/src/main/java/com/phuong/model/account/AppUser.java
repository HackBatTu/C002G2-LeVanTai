package com.phuong.model.account;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.phuong.model.Customer;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String userName;

    @JsonBackReference
    @Column(nullable = false)
    private String password;

    @Column(columnDefinition = "bit(1) default 0")
    private Boolean status;

    @Column(columnDefinition = "bit(1) default 0")
    private Boolean isDeleted;

    @JsonIgnore
    @OneToMany(mappedBy = "appUser")
    private List<UserRole> userRoles;

    @JsonIgnore
    @OneToOne(mappedBy = "appUser")
    private Customer customer;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AppUser appUser = (AppUser) o;
        return id != null && Objects.equals(id, appUser.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
