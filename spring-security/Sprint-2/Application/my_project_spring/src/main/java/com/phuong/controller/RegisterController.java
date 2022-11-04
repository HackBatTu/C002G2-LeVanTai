package com.phuong.controller;

import com.phuong.dto.RegisterRequest;
import com.phuong.service.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class RegisterController {

    @Autowired
    private IAppUserService appUserService;

    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    public ResponseEntity<?> getUserRegister(@Valid @RequestBody RegisterRequest registerRequest,
                                             BindingResult bindingResult) {
        RegisterRequest registerRequestDto = new RegisterRequest();
        registerRequestDto.setAppUserList(this.appUserService.findAll());
        registerRequestDto.validate(registerRequest, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        this.appUserService.registerUser(registerRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
