package com.link.controller;


import com.link.model.service.Facility;
import com.link.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/facility")
public class FacilityController {

    @Autowired
    private IFacilityService iFacilityService;

    @GetMapping("")
    public String facilityList(Model model, @PageableDefault(value = 5)Pageable pageable, @RequestParam Optional<String> search){
        String searchName =search.orElse("");
        model.addAttribute("searchName",searchName);
        model.addAttribute("facilityList" , iFacilityService.findAllFacility(searchName,pageable));
        return "facility/list";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("facilityList",new Facility());
        model.addAttribute("facilityTypeList",iFacilityService.findAllFacilityType());
        model.addAttribute("rentTypeList",iFacilityService.findAllRentType());
        return "facility/create";
    }

    @PostMapping("/create")
    public String save(Facility facility){
        this.iFacilityService.save(facility);
        return "redirect:/facility";
    }

    @GetMapping("/edit/{id}")
    public String formUpdate(@PathVariable Integer id,Model model){
        model.addAttribute("facilityList",iFacilityService.findById(id));
        model.addAttribute("facilityTypeList",iFacilityService.findAllFacilityType());
        model.addAttribute("rentTypeList",iFacilityService.findAllRentType());
        return "facility/update";
    }

    @PostMapping("/edit")
    public String update(Facility facility){
        this.iFacilityService.save(facility);
        return "redirect:/facility";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        iFacilityService.delete(id);
        return "redirect:/facility";
    }
}
