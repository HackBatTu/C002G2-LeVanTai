package com.example.controller;

import com.example.dto.EmployeeDTO;
import com.example.model.AppUser;
import com.example.model.Employee;
import com.example.model.Position;
import com.example.service.IEmployeeService;
import com.example.service.IPositionService;
import com.example.service.IAppUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/rest")
public class EmployeeRestController {

    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private IPositionService iPositionService;
    @Autowired
    private IAppUserService iUserService;

    /**
     * @param
     * @return Position list
     * @creator TaiLV
     * Date 09/08/2022
     */
    @GetMapping("/position")
    public ResponseEntity<List<Position>> getAllPosition() {
        List<Position> positionList = iPositionService.getAllPosition();
        return new ResponseEntity<>(positionList, HttpStatus.OK);
    }

    /**
     * @param
     * @return Position list
     * @creator TaiLV
     * Date 09/08/2022
     */
    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> getAllEmployee() {
        List<Employee> employeeList = iEmployeeService.getAllEmployee();
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    /**
     * @param
     * @return AppUser list
     * @creator TaiLV
     * Date 09/08/2022
     */
    @GetMapping("/user")
    public ResponseEntity<List<AppUser>> getAllUser() {
        List<AppUser> userList = iUserService.getAllUser();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    /**
     * @param id if id null : Bad request
     * @return object Employee
     * @creator TaiLV
     * Date 09/08/2022
     */
    @GetMapping("/findId/{id}")
    public ResponseEntity<Employee> findByID(@PathVariable Integer id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(iEmployeeService.findById(id), HttpStatus.OK);
    }

    /**
     * @param employeeDTO
     * @param bindingResult if employee null : Create new employee
     * @return create Employee success
     * @creator TaiLV
     * Date 09/08/2022
     */
    @PostMapping("/create")
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody EmployeeDTO employeeDTO, BindingResult bindingResult) {
        Employee employee = new Employee();

        new EmployeeDTO().validate(employeeDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        AppUser appUser = new AppUser();
        appUser.setIsDeleted(0);
        appUser.setPassword("123456");
        appUser.setUsername(employee.getUser().getUsername());

        BeanUtils.copyProperties(employeeDTO, employee);
        return new ResponseEntity<>(iEmployeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    /**
     * @param employeeDTO
     * @param bindingResult
     * @param id            if employee null : Create new employee
     * @return update Employee success
     * @creator TaiLV
     * Date 09/08/2022
     */
    @PatchMapping("/edit/{id}")
    public ResponseEntity<Employee> editProduct(@RequestBody EmployeeDTO employeeDTO, BindingResult bindingResult, @PathVariable Integer id) {
        Employee employee = this.iEmployeeService.findById(id);
        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        new EmployeeDTO().validate(employeeDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        BeanUtils.copyProperties(employeeDTO, employee);
        return new ResponseEntity<>(iEmployeeService.editEmployee(employee), HttpStatus.CREATED);
    }

}
