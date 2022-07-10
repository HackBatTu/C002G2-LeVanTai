package com.link.controller.employee;

import com.link.model.employee.AppUser;
import com.link.model.employee.Division;
import com.link.model.employee.EducationDegree;
import com.link.model.employee.Position;
import com.link.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;

    @GetMapping("")
    public String goEmployee() {
    return "employee/list";
    }

    @ModelAttribute("divisionList")
    public List<Division> getAllDivision() {
        return this.iEmployeeService.findAllDivisionList();
    }

    @ModelAttribute("educationDegreeList")
    public List<EducationDegree> getAllEducationDegree() {
        return this.iEmployeeService.findAllEducationDegreeList();
    }

    @ModelAttribute("positionList")
    public List<Position> getAllPosition() {
        return this.iEmployeeService.findAllPosition();
    }

    @ModelAttribute("appUserList")
    public List<AppUser> getAllUser() {
        return this.iEmployeeService.findAllUser();
    }
}
