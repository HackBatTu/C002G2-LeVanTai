package com.coffee.dto.employe;


import com.coffee.model.account.AppUser;
import com.coffee.model.employee.Position;
import lombok.Data;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.sql.Date;

@Data
public class EmployeeDTOCreate implements Validator {
    private Integer id;

    @NotBlank(message = "vui lòng điền thông tin")
    private String name;

    @NotBlank(message = "vui lòng điền thông tin")
    private String image;

    @NotBlank(message = "vui lòng điền thông tin")
    private String phoneNumber;

    @NotBlank(message = "vui lòng điền thông tin")
    private String address;

    @NotBlank(message = "vui lòng điền thông tin")
    private String email;

    private int gender;

    private Date birthday;

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
        EmployeeDTOCreate employeeDTO = (EmployeeDTOCreate) target;

        if (employeeDTO.getAppUser().getUserName().equals("admin")) {
            errors.rejectValue("appUser", "create.user", "vui lòng nhập tài khoản khác admin");
        }
        if (employeeDTO.getAppUser().getUserName().equals("root")) {
            errors.rejectValue("appUser", "create.user", "vui lòng nhập tài khoản khác root");
        }
        if (employeeDTO.getAppUser().getUserName().matches("^[0-9][A-Za-z0-9!@#$%^&*()_+;':<>?,.]$")) {
            errors.rejectValue("appUser", "create.user", "vui lòng nhập tài khoản không có số đầu");
        }
        if (employeeDTO.getAppUser().getUserName().length() < 6) {
            errors.rejectValue("appUser", "create.user", "vui lòng nhập tài khoản lớn hơn 6 kí tự");
        }
        if (employeeDTO.getAppUser().getUserName().isEmpty()) {
            errors.rejectValue("appUser", "create.user", "Tài khoản đã tồn tại vui lòng nhập mới");
        }
        if (employeeDTO.getSalary() % 100000 != 0) {
            errors.rejectValue("salary", "create.salary", "vui lòng nhập lương là bội của 100.000");
        }
    }


}
