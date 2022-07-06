package com.link.controller;

import com.link.model.Customer;
import com.link.model.Employee;
import com.link.service.ICustomerService;
import com.link.service.IEmployeeService;
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
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;

    @GetMapping("")
    public String listCustomer(Model model, @PageableDefault(value = 5)Pageable pageable, Optional<String> search){
        String searchName = search.orElse("");
        model.addAttribute("searchName", searchName);
        model.addAttribute("employeeList", iEmployeeService.findAllEmployee(searchName, pageable));
        return "employee/list";
    }

    @GetMapping("/create")
    public String formCreate(Model model){
        model.addAttribute("employeeList", new Employee());
        model.addAttribute("positionList",iEmployeeService.findAllPosition());
        model.addAttribute("educationDegreeList",iEmployeeService.findAllEducationDegreeList());
        model.addAttribute("divisionList",iEmployeeService.findAllDivisionList());
        model.addAttribute("appUserList",iEmployeeService.findAllUser());
        return "employee/list";
    }
    @PostMapping("/create")
    public String saveEmployee(Employee employee){
        this.iEmployeeService.save(employee);
        return "redirect:/employee";
    }
    @GetMapping("/edit/{id}")
    public String formUpdate(Model model, @PathVariable Integer id){
        model.addAttribute("employeeList", iEmployeeService.findById(id));
        model.addAttribute("positionList",iEmployeeService.findAllPosition());
        model.addAttribute("educationDegreeList",iEmployeeService.findAllEducationDegreeList());
        model.addAttribute("divisionList",iEmployeeService.findAllDivisionList());
        model.addAttribute("appUserList",iEmployeeService.findAllUser());
        return "employee/list";
    }
    @PostMapping("/edit")
    public String editEmployee(Employee employee){
        this.iEmployeeService.save(employee);
        return "redirect:/employee";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Integer id){
        this.iEmployeeService.deleteEmployee(id);
        return "redirect:/employee";
    }


}
