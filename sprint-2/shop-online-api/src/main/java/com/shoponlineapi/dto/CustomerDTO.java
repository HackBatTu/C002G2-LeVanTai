package com.shoponlineapi.dto;

import com.shoponlineapi.model.Customer;
import com.shoponlineapi.model.account.AppUser;
import lombok.Data;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;


@Data
public class CustomerDTO implements Validator {
    @NotBlank
    private String name;
    private String image;
    @Email
    private String email;
    private Date birthday;
    private String phone;
    private String hobbies;
    private AppUser appUser;
    private Boolean isDeleted;

    private List<Customer> customerList;
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDTO customerDTO =(CustomerDTO) target;
        List<Customer> customers = this.getCustomerList();
        if(!customers.isEmpty()){
            for (Customer customer: customers){
                if(customer.getEmail().equals(customerDTO.getEmail())){
                    errors.rejectValue("email","","emailExists");
                }
            }
        }
    }
}
