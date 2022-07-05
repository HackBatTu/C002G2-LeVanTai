package com.link.controller;


import com.link.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/facility")
public class FacilityController {

    @Autowired
    private IFacilityService iFacilityService;

    @GetMapping("")
    public String facilityList(){
        return "facility/list";
    }

    @GetMapping("/create")
    public String create(){
        return "facility/create";
    }
    @GetMapping("/edit")
    public String edit(){
        return "facility/update";
    }

}
