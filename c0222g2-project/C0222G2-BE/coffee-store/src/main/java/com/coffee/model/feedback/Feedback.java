package com.coffee.model.feedback;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String code;

    private String creator;

    private String email;

    @Column(columnDefinition = "text")
    private String content;

    private Integer rating;

    private Date feedbackDate;

    @Column(columnDefinition = "text")
    private String image;

    @Column(columnDefinition = "bit(1) default 0")
    private Boolean isDeleted;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Feedback feedBack = (Feedback) o;
        return id != null && Objects.equals(id, feedBack.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
