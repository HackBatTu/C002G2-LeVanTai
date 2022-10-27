package com.shoponlineapi.controller;

import com.shoponlineapi.dto.RegisterDTO;
import com.shoponlineapi.model.account.AppUser;
import com.shoponlineapi.service.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("")
public class UserRestController {
    @Autowired
    private IAppUserService appUserService;

    @PostMapping("/rest/user/register")
    public ResponseEntity<?> getUserRegister(@Valid @RequestBody RegisterDTO registerDTO,
                                             BindingResult bindingResult) {
        RegisterDTO registerRequestDto = new RegisterDTO();
        registerRequestDto.setAppUserList(this.appUserService.getAllUser());
        registerRequestDto.validate(registerDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        this.appUserService.registerUser(registerDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping(value = "/rest/get/user/{username}")
    public ResponseEntity<AppUser> getAppUserByUsername(@PathVariable String username) {
        AppUser appUser = this.appUserService.getAppUserByUsername(username);
        return new ResponseEntity<>(appUser, HttpStatus.OK);
    }
    @GetMapping("/users")
    public ResponseEntity<List<AppUser>> getAllUser(){
        List<AppUser> appUser = appUserService.getAllUser();
        return new ResponseEntity<>(appUser,HttpStatus.OK);
    }
}
