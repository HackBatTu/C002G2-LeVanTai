package com.link.controller;

import com.link.model.Customer;
import com.link.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping("")
    public String listCustomer(Model model, @PageableDefault(value = 5)Pageable pageable, Optional<String> search){
        String searchName = search.orElse("");
        model.addAttribute("searchName", searchName);
        model.addAttribute("customerList", iCustomerService.findAllCustomer(searchName, pageable));
        return "customer/list";
    }

    @GetMapping("/create")
    public String formCreate(Model model){
        model.addAttribute("customerList", new Customer());
        model.addAttribute("customerTypeList", iCustomerService.findAllCustomerType());
        return "customer/create";
    }
    @PostMapping("/create")
    public String saveCustomer(Customer customer){
        this.iCustomerService.save(customer);
        return "redirect:/customer";
    }
    @GetMapping("/edit/{id}")
    public String formEdit(Model model, @PathVariable Integer id){
        model.addAttribute("customerList", iCustomerService.findById(id));
        model.addAttribute("customerTypeList", iCustomerService.findAllCustomerType());
        return "customer/update";
    }
    @PostMapping("/edit")
    public String updateCustomer(Customer customer){
        this.iCustomerService.save(customer);
        return "redirect:/customer";
    }
    @GetMapping("/delete/{id}")
    public String formEdit( @PathVariable Integer id){
       this.iCustomerService.deleteCustomer(id);
        return "redirect:/customer";
    }

//    @GetMapping("/customer-using-service")
//    public String listCustomerUsingService(Model model){
//        model.addAttribute("listCustomerUsingService",iCustomerService.findAllCustomerUsingService());
//        return "customer/customer-using-service";
//    }
}
