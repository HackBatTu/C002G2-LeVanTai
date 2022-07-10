package com.link.controller.contract;


import com.link.model.contract.Contract;
import com.link.model.contract.DetailsContract;
import com.link.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService iContractService;

    @GetMapping("")
    public String listContract(Model model, @PageableDefault(value = 5)Pageable pageable){
        model.addAttribute("contractList", iContractService.getAllContract(pageable));
        model.addAttribute("facilityAttachList", iContractService.getAllFacilityAttach());
        model.addAttribute("detailsContractList", iContractService.getAllDetailsContract());
        model.addAttribute("detailsContractList", new DetailsContract());
        return "contract/list";
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
    public String saveContract(Contract contract){
        iContractService.save(contract);
        return "redirect:/contract";
    }
    @GetMapping("/createDetailsContract")
    public String createDetailsContract(Model model){
        model.addAttribute("detailsContractList", new DetailsContract());
        model.addAttribute("facilityAttachList", iContractService.getAllFacilityAttach());
        return "contract/list";
    }
    @PostMapping("/createDetailsContract")
    public String saveDetailsContract(DetailsContract detailsContract){
        iContractService.saveDetailsContract(detailsContract);
        return "redirect:/contract";
    }


    @GetMapping("delete/{id}")
    public String deleteContract(@PathVariable Integer id){
        iContractService.deleteContract(id);
        return "redirect:/contract";
    }


//    @GetMapping("")
//    public String listContract(Model model, @PageableDefault(value = 5)Pageable pageable,  Optional<String> searchDateIn, Optional<String> searchDateOut){
//        String dateIn = searchDateIn.orElse("1970-01-01");
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        String dateOut = searchDateOut.orElse(simpleDateFormat.format(new Date()));
//
//        model.addAttribute("contractList", iContractService.getAllContract(pageable, dateIn, dateOut));
//        model.addAttribute("facilityAttachList", iContractService.getAllFacilityAttach());
//        model.addAttribute("detailsContractList", iContractService.getAllDetailsContract());
//        model.addAttribute("detailsContractList", new DetailsContract());
//        return "contract/list";
//    }
//    @GetMapping("")
//    public String goHome(){
//        return "contract/list";
//    }
//
//    @ModelAttribute("employeeList")
//    public List<Employee> getAllEmployee(){
//        return iContractService.findAllEmployee();
//    }
//    @ModelAttribute("customerList")
//    public List<Customer> getAllCustomer(){
//        return iContractService.findAllCustomer();
//    }
//    @ModelAttribute("facilityList")
//    public List<Facility> getAllFacility(){
//        return iContractService.findAllFacility();
//    }
}
