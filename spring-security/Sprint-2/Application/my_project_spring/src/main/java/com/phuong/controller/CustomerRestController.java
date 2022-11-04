package com.phuong.controller;

import com.phuong.dto.CustomerDto;
import com.phuong.model.Customer;
import com.phuong.service.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class CustomerRestController {

    @Autowired
    private ICustomerService customerService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/get/customer/{username}")
    public ResponseEntity<Customer> getCustomerByUsername(@PathVariable String username) {
        Customer customer = this.customerService.getCustomerByUsername(username);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/checkout/customer")
    public ResponseEntity<?> saveCustomer(@Valid @RequestBody CustomerDto customerDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        this.customerService.save(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/customer/list")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customerList = this.customerService.findAll();

        if (customerList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }
}
