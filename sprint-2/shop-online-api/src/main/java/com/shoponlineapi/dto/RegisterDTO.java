package com.shoponlineapi.dto;

import com.shoponlineapi.model.account.AppUser;
import lombok.Data;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Pattern;
import java.util.List;

@Data
public class RegisterDTO implements Validator{
    @Pattern(regexp = "^(?=[a-zA-Z0-9._]{8,20}$)(?!.*[_.]{2})[^_.].*[^_.]$")
    private String username;
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$")
    private String password;
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$")
    private String confirmPassword;
    private List<AppUser> appUserList;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        RegisterDTO registerDTO = (RegisterDTO) target;
        if (!registerDTO.getPassword().equals(registerDTO.getConfirmPassword())) {
            errors.rejectValue("password","","passwordNotSame");
        }
        for (AppUser appUser: this.appUserList) {
            if (appUser.getUserName().equals(registerDTO.getUsername())) {
                errors.rejectValue("username", "", "usernameExists");
            }
        }
    }
}
