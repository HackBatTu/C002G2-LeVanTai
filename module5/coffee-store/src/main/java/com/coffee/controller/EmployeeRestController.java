package com.coffee.controller;

import com.coffee.dto.employe.EmployeeDTOCreate;
import com.coffee.dto.employe.EmployeeDTOEdit;
import com.coffee.model.account.AppUser;
import com.coffee.model.employee.Employee;
import com.coffee.model.employee.Position;
import com.coffee.service.IAppUserService;
import com.coffee.service.IEmployeeService;
import com.coffee.service.IPositionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
     * @creator TaiLV
     * Date 09/08/2022
     * @param
     * @return  Position list
     */
    @GetMapping("/position")
    public ResponseEntity<List<Position>> getAllPosition() {
        List<Position> positionList = iPositionService.getAllPosition();
        return new ResponseEntity<>(positionList, HttpStatus.OK);
    }

    /**
     * @creator TaiLV
     * Date 09/08/2022
     * @param
     * @return  AppUser list
     */
    @GetMapping("/user")
    public ResponseEntity<List<AppUser>> getAllUser() {
        List<AppUser> userList = iUserService.getAllUser();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    /**
     * @function ( find the employee of the id )
     * @creator TaiLV
     * @date-create 09/08/2022
     * @param id
     * @return true: id status 200 / false: status 404
     */
    @GetMapping("/employee/findId/{id}")
    public ResponseEntity<Employee> findById(@PathVariable Integer id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(iEmployeeService.findById(id), HttpStatus.OK);
    }



    /**
     * @creator TaiLV
     * @function ( create the value of the employee )
     * Date 09/08/2022
     * @param employeeDTO
     * @param bindingResult
     * if employee null : Create new employee
     * @return  true: employee, status 200 / false: status 404
     */
    @PostMapping("/employee/create")
    public ResponseEntity<Void> saveEmployee(@Valid @RequestBody EmployeeDTOCreate employeeDTO , BindingResult bindingResult) {

        new EmployeeDTOCreate().validate(employeeDTO,bindingResult);

        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Employee employee =new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);


        iEmployeeService.saveEmployee(employee);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * @creator TaiLV
     * @function ( edit the value of the employee )
     * Date 09/08/2022
     * @param employeeDTOEdit
     * @param bindingResult
     * if employee null : Create new employee
     * @return  true: employee, status 200 / false: status 404
     */
    @PatchMapping(value = "/employee/edit")
    public ResponseEntity<Void> editEmployee(@Valid @RequestBody EmployeeDTOEdit employeeDTOEdit , BindingResult bindingResult) {

        Employee employee = this.iEmployeeService.findById(employeeDTOEdit.getId());

        if(employee == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        new EmployeeDTOEdit().validate(employeeDTOEdit,bindingResult);
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        BeanUtils.copyProperties(employeeDTOEdit, employee);
        iEmployeeService.editEmployee(employee);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }



}
