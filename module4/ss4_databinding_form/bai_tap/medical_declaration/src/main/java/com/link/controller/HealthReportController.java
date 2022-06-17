package com.link.controller;

import com.link.model.HealthReport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HealthReportController {
    @GetMapping("/")
    public String showHealth(Model model){
        model.addAttribute("healthReport", new HealthReport());
        return "index";
    }
    @PostMapping("/create")
    public  String getHealth(@ModelAttribute HealthReport healthReport, Model model){
        model.addAttribute("result", healthReport);
        return  "show";
    }

}
