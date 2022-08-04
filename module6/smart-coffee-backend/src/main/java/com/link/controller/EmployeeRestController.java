package com.link.controller;

import com.link.model.Employee;
import com.link.model.Position;
import com.link.model.User;
import com.link.reponsitory.IEmployeeRepository;
import com.link.service.impl.IEmployeeService;
import com.link.service.impl.IPositionService;
import com.link.service.impl.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/rest")
public class EmployeeRestController {
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private IPositionService iPositionService;
    @Autowired
    private IUserService iUserService;

    @GetMapping("/position")
    public ResponseEntity<List<Position>> getAllPosition(){
        List<Position> positionList = iPositionService.getAllPosition();
        return new ResponseEntity<>(positionList, HttpStatus.OK);
    }
    @GetMapping("/user")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> userList = iUserService.getAllUser();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }
    @GetMapping("/findId/{id}")
    public ResponseEntity<Employee> findByID(@PathVariable Integer id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(iEmployeeService.findById(id), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        if(employee.getUser().getUserName().isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(iEmployeeService.save(employee), HttpStatus.CREATED);
        }
    }

    @PatchMapping("/edit")
    public ResponseEntity<Employee> editProduct(@RequestBody Employee employee) {
        return new ResponseEntity<>(iEmployeeService.save(employee), HttpStatus.CREATED);
    }

}
