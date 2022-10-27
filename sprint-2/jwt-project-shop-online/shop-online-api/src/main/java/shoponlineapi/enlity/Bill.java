package shoponlineapi.enlity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Data
@Entity
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

    @JsonIgnore
    @OneToMany(mappedBy = "bill")
    private List<OrderService> productOrderList;

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
