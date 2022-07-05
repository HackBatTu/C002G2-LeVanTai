package com.link.controller;

import com.link.service.ICustomerService;
import com.link.service.IDetailsContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/details-contract")
public class DetailsContractController {
    @Autowired
    private IDetailsContractService iDetailsContractService;

    @GetMapping("")
    public String listCustomer(){
        return "details-contract/list";
    }
}
