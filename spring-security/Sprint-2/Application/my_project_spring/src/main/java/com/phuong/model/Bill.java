package com.phuong.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String code;

    private Date creationDate;

    @Column(columnDefinition = "bit(1) default 0")
    private Boolean isDeleted;

    @OneToOne
    @JoinColumn(name = "feedback_id", referencedColumnName = "id")
    private Feedback feedback;

    @OneToMany(mappedBy = "bill")
    @JsonIgnore
    private List<ProductOrder> productOrderList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Bill bill = (Bill) o;
        return id != null && Objects.equals(id, bill.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
