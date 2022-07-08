package com.link.controller.contract;

import com.link.model.Customer;
import com.link.model.contract.Contract;
import com.link.model.employee.Employee;
import com.link.model.service.Facility;
import com.link.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService iContractService;

//    @GetMapping("")
//    public String listContract(Model model, @PageableDefault(value = 5)Pageable pageable){
//        model.addAttribute("contractList", iContractService.getAllContract(pageable));
//        return "contract/list";
//    }
//
//    @GetMapping("/create")
//    public String formCreate(Model model){
//        model.addAttribute("contractList", new Contract());
//        model.addAttribute("employeeList", iContractService.findAllEmployee());
//        model.addAttribute("customerList", iContractService.findAllCustomer());
//        model.addAttribute("facilityList", iContractService.findAllFacility());
//        return "contract/list";
//    }

//    @PostMapping("/create")
//    public String saveContract(Contract contract){
//        iContractService.save(contract);
//        return "redirect:/list";
//    }

    @GetMapping("")
    public String goHome(){
        return "contract/list";
    }

    @ModelAttribute("employeeList")
    public List<Employee> getAllEmployee(){
        return iContractService.findAllEmployee();
    }
    @ModelAttribute("customerList")
    public List<Customer> getAllCustomer(){
        return iContractService.findAllCustomer();
    }
    @ModelAttribute("facilityList")
    public List<Facility> getAllFacility(){
        return iContractService.findAllFacility();
    }
}
