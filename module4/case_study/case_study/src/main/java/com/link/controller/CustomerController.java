package com.link.controller;

import com.link.dto.CustomerDTO;
import com.link.model.customer.Customer;
import com.link.service.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
        model.addAttribute("customerDTO", new CustomerDTO());
        model.addAttribute("customerTypeList", iCustomerService.findAllCustomerType());
        return "customer/create";
    }
    @PostMapping("/create")
    public String saveCustomer(@Valid @ModelAttribute("customerDTO") CustomerDTO customerDTO , BindingResult bindingResult,Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("customerTypeList", iCustomerService.findAllCustomerType());
            return "customer/create";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO,customer);
        this.iCustomerService.save(customer);
        return "redirect:/customer";
    }


    @GetMapping("/edit/{id}")
    public String formEdit(Model model, @PathVariable Integer id){
        Customer customer =  iCustomerService.findById(id);
        CustomerDTO customerDTO = new CustomerDTO();
        BeanUtils.copyProperties(customer,customerDTO);
        model.addAttribute("customerDTO",customerDTO);
        model.addAttribute("customerTypeList", iCustomerService.findAllCustomerType());
        return "customer/update";
    }
    @PostMapping("/edit")
    public String updateCustomer(@Valid @ModelAttribute CustomerDTO customerDTO, BindingResult bindingResult,Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("customerTypeList", iCustomerService.findAllCustomerType());
            return "customer/update";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO,customer);
        this.iCustomerService.save(customer);
        return "redirect:/customer";
    }
    @GetMapping("/delete/{id}")
    public String formEdit( @PathVariable Integer id){
       this.iCustomerService.deleteCustomer(id);
        return "redirect:/customer";
    }

}
