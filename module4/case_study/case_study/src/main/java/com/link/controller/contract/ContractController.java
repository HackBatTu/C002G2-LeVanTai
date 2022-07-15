package com.link.controller.contract;


import com.link.dto.ContractDTO;
import com.link.model.contract.Contract;
import com.link.model.contract.DetailsContract;
import com.link.model.service.Facility;
import com.link.service.IContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Optional;


@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService iContractService;

    @GetMapping("")
    public String listContract(Model model, @PageableDefault(value = 5)Pageable pageable, Optional<String> searchDateIn, Optional<String> searchDateOut){
        String dateIn = searchDateIn.orElse("1970-01-01");
        model.addAttribute("dateIn", dateIn);

        String dateOut = searchDateOut.orElse("2100-01-01");
        model.addAttribute("dateOut", dateOut);

        model.addAttribute("contractList", iContractService.getAllContract(pageable, dateIn, dateOut));

        model.addAttribute("facilityAttachList", iContractService.getAllFacilityAttach());
        model.addAttribute("detailsContractList", iContractService.getAllDetailsContract());
        model.addAttribute("detailsContract", new DetailsContract());
        return "contract/list";
    }

    @GetMapping("/customer-using-service")
    public String listCustomerUsingService(Model model,@PageableDefault(value = 5)Pageable pageable,Optional<String> search){
        String searchName = search.orElse("");
        model.addAttribute("searchName", searchName);
        model.addAttribute("customerUsingServiceList",iContractService.findAllCustomerUsingService(pageable,searchName));
        return "contract/customer-using-service";
    }

    @GetMapping("/create")
    public String formCreate(Model model){
        model.addAttribute("contractList", new Contract());
        model.addAttribute("employeeList", iContractService.findAllEmployee());
        model.addAttribute("customerList", iContractService.findAllCustomer());
        model.addAttribute("facilityList", iContractService.findAllFacility());
        return "contract/create";
    }

    @PostMapping("/create")
    public String saveContract(@Valid @ModelAttribute ContractDTO contractDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){

            return "contract/create";
        }
        Contract contract = new Contract();
        BeanUtils.copyProperties(contract,contractDTO);
        this.iContractService.save(contract);
        return "redirect:/contract";
    }

    @PostMapping("/createDetailsContract")
    public String saveDetailsContract(@ModelAttribute DetailsContract detailsContract){
        iContractService.saveDetailsContract(detailsContract);
        return "redirect:/contract";
    }


    @GetMapping("delete/{id}")
    public String deleteContract(@PathVariable Integer id){
        iContractService.deleteContract(id);
        return "redirect:/contract";
    }
}
