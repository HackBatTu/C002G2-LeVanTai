package com.coffee.dto.employe;

import com.coffee.model.account.AppUser;
import com.coffee.model.employee.Position;
import lombok.Data;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.sql.Date;

@Data
public class EmployeeDTOEdit implements Validator {
    private Integer id;

    @NotBlank(message = "vui lòng điền thông tin")
    private String name;

    private Date birthday;

    private int gender;
    @NotBlank(message = "vui lòng điền thông tin")
    private String phoneNumber;

    @NotBlank(message = "vui lòng điền thông tin")
    private String address;

    @NotBlank(message = "vui lòng điền thông tin")
    @Email(message = "vui lòng nhập đúng định dạng email")
    private String email;

    @NotBlank(message = "vui lòng điền thông tin")
    private String image;

    @PositiveOrZero(message = "vui lòng nhập lương lớn hơn 0 ")
    private Double salary;
    private Integer isDeleted;

    private Position position;

    private AppUser appUser;
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        EmployeeDTOEdit employeeDTOEdit = (EmployeeDTOEdit) target;
        if (employeeDTOEdit.getSalary() % 100000 != 0) {
            errors.rejectValue("salary", "create.salary", "vui lòng nhập lương là bội của 100.000");
        }
    }

}
