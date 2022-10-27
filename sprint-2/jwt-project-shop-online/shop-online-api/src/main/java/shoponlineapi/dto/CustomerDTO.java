package shoponlineapi.dto;

import lombok.Data;
import shoponlineapi.enlity.account.AppUser;

import java.util.Date;


@Data
public class CustomerDTO {
    private Integer id;

    private String name;

    private String phone;

    private String address;

    private String image;

    private String hobbies;

    private Boolean isDeleted;

    private String email;

    private Date birthday;

    private AppUser appUser;
}
