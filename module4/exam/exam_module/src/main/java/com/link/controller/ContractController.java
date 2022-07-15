package com.link.controller;

import com.link.model.Contract;
import com.link.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private IContractService contractService;

    @GetMapping("")
    public String listContract(Model model){
        model.addAttribute("contractList", contractService.findAll());
        return "contract/list";
    }

    @GetMapping("/create")
    public String formCreate(Model model){
        model.addAttribute("contract", new Contract());
        model.addAttribute("roomList", contractService.findAllRoom());
        return "contract/create";
    }

    @PostMapping("/create")
    public String saveContract(Contract contract){
        this.contractService.save(contract);
        return "redirect:/contract";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id){
        contractService.deleteById(id);
        return "redirect:/contract";
    }
}
