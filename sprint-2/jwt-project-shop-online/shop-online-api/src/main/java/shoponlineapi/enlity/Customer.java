package shoponlineapi.enlity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;
import shoponlineapi.enlity.account.AppUser;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(columnDefinition = "text")
    private String image;
    private String email;
    @Column(columnDefinition = "date")
    private Date birthday;
    private String phone;
    private String hobbies;
    @Column(columnDefinition = "text")
    private String address;
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private AppUser appUser;

    @Column(columnDefinition = "bit(1) default 0")
    private Boolean isDeleted;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    List<OrderService> orderServiceList;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    List<Feedback> feedbackList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Customer customer = (Customer) o;
        return id != null && Objects.equals(id, customer.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
