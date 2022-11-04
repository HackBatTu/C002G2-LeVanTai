package com.phuong.model;

import lombok.*;
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

    private String content;

    private Date feedbackDate;

    @Column(columnDefinition = "text")
    private String image;

    private Integer rate;

    @Column(columnDefinition = "bit(1) default 0")
    private Boolean isDeleted;

    @OneToOne(mappedBy = "feedback")
    private Bill bill;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Feedback feedback = (Feedback) o;
        return id != null && Objects.equals(id, feedback.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
