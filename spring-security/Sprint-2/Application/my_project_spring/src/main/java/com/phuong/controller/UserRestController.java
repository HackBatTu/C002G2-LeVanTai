package com.phuong.controller;

import com.phuong.model.Customer;
import com.phuong.model.ProductOrder;
import com.phuong.model.account.AppUser;
import com.phuong.repository.IAppUserRepository;
import com.phuong.service.IProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class UserRestController {

    @Autowired
    private IAppUserRepository appUserRepository;

    @Autowired
    private IProductOrderService productOrderService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/users")
    public ResponseEntity<List<AppUser>> getAllUser() {
        List<AppUser> appUsers = this.appUserRepository.findAll();
        return new ResponseEntity<>(appUsers, HttpStatus.OK);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/get/user/{username}")
    public ResponseEntity<AppUser> getAppUserByUsername(@PathVariable String username) {
        AppUser appUser = this.appUserRepository.getAppUserByUsername(username);
        return new ResponseEntity<>(appUser, HttpStatus.OK);
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping(value = "/get/orders")
    public ResponseEntity<?> getOrdersByCustomer(@RequestBody Customer customer, @PageableDefault(5) Pageable pageable) {
        Page<ProductOrder> productOrderPage = this.productOrderService.findProductOrderByUserName(pageable ,customer);
        if (productOrderPage.hasContent()) {
            return new ResponseEntity<>(productOrderPage, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
