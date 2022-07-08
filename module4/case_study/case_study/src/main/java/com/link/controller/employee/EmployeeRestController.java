package com.link.controller.employee;

import com.link.model.Employee;
import com.link.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/restEmployee")
public class EmployeeRestController {

    @Autowired
    private IEmployeeService iEmployeeService;

    @GetMapping("")
    public ResponseEntity<Page<Employee>> listEmployee(Model model , @PageableDefault(value = 20) Pageable pageable, Optional<String> search){
        String searchName = search.orElse("");
        Page<Employee> employeePage =iEmployeeService.findAllEmployee(searchName,pageable);
        return new ResponseEntity<>(employeePage, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(iEmployeeService.save(employee), HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Employee> editEmployee(@PathVariable Integer id, @RequestBody Employee employee){
        Optional<Employee> employeeOptional =Optional.ofNullable(iEmployeeService.findById(id));
        employee.setId(employeeOptional.get().getId());
        return new ResponseEntity<>(iEmployeeService.save(employee), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<Employee> deleteEmployee(@PathVariable Integer id){
        Optional<Employee> employeeOptional =Optional.ofNullable(iEmployeeService.findById(id));
        iEmployeeService.deleteEmployee(id);
        return new ResponseEntity<>(employeeOptional.get(),HttpStatus.NO_CONTENT);
    }


}
