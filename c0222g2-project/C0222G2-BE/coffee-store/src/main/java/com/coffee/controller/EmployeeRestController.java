package com.coffee.controller;

import com.coffee.dto.EmployeeDTOCreate;
import com.coffee.dto.EmployeeDTOEdit;
import com.coffee.dto.IEmployeeDTO;
import com.coffee.model.account.AppUser;
import com.coffee.model.employee.Employee;
import com.coffee.model.employee.Position;
import com.coffee.service.IAppUserService;
import com.coffee.service.IEmployeeService;
import com.coffee.service.IPositionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


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
     * Create by TuyenTN
     * Create date: 16:30
     * Method getAllEmployee show list and paging and search
     *
     * @param pageable
     * @param searchName
     * @param searchPhone
     * @param searchAccount
     * @return
     */
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/employee/page")
    public ResponseEntity<Page<IEmployeeDTO>> getAllEmployee(@PageableDefault(10) Pageable pageable,
                                                             Optional<String> searchName,
                                                             Optional<String> searchPhone,
                                                             Optional<String> searchAccount) {
        String searchByName = searchName.orElse("");
        String searchByPhone = searchPhone.orElse("");
        String searchByAccount = searchAccount.orElse("");

        Page<IEmployeeDTO> employeePage = this.iEmployeeService.getAllEmployee(pageable, searchByName, searchByPhone, searchByAccount);
        if (employeePage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employeePage, HttpStatus.OK);
    }

    /**
     * Create by TuyenTN
     * Create data: 9-8-2022 23:14
     * findEmployeeById(id)
     *
     * @param id
     * @return
     */
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/employee/find/{id}")
    public ResponseEntity<IEmployeeDTO> findEmployeeById(@PathVariable Integer id) {
        IEmployeeDTO iEmployeeDTO = this.iEmployeeService.findEmployeeById(id);
        if (iEmployeeDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(iEmployeeDTO, HttpStatus.OK);
    }

    /**
     * Create by TuyenTN
     * Create data: 9-8-2022 23:14
     * deleteEmployeeById(id)
     *
     * @param id
     * @return
     */
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/employee/delete/{id}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable Integer id) {
        IEmployeeDTO iEmployeeDTO = this.iEmployeeService.findEmployeeById(id);
        if (iEmployeeDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.iEmployeeService.deleteEmployeeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * end code TuyenTN
     */

//-------------------------------------------------------------------------------------------------------------------
    /**
     * start code TaiLV
     */

    /**
     * @creator TaiLV
     * Date 09/08/2022
     * @param
     * @return  Position list
     */
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
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
     * @param username
     * @return true: id status 200 / false: status 404
     */
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/employee/findUserName/{username}")
    public ResponseEntity<AppUser> findByUserName(@PathVariable String username) {
        if (username == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(iUserService.findAppUserByUserName(username), HttpStatus.OK);
    }

    /**
     * @function ( find the employee of the id )
     * @creator TaiLV
     * @date-create 12/08/2022
     * @param id
     * @return true: id status 200 / false: status 404
     */
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
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
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/employee/create")
    public ResponseEntity<?> saveEmployee(@Valid @RequestBody EmployeeDTOCreate employeeDTO , BindingResult bindingResult) {

        EmployeeDTOCreate employeeDTOCreate = new EmployeeDTOCreate();
        employeeDTOCreate.setEmployeeList(this.iEmployeeService.findAll());

        employeeDTOCreate.validate(employeeDTO,bindingResult);

        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getFieldError(),HttpStatus.INTERNAL_SERVER_ERROR);
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
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
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
