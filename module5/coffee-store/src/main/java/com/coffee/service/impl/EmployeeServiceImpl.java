package com.coffee.service.impl;



import com.coffee.model.account.AppRole;
import com.coffee.model.account.AppUser;
import com.coffee.model.account.UserRole;
import com.coffee.model.employee.Employee;
import com.coffee.repository.IEmployeeRepository;
import com.coffee.service.IAppUserService;
import com.coffee.service.IEmployeeService;
import com.coffee.service.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    @Autowired
    private IAppUserService iAppUserService;

    @Autowired
    private IUserRoleService iUserRoleService;






    /**
     * @creator TaiLV
     * Date 09/08/2022
     * @param employee
     * if employee null : Create new employee
     * @return  true: create employee success, status 200 / false: status 404
     * @return  create Employee success
     */
    @Override
    public void saveEmployee(Employee employee) {
        AppRole appRole = new AppRole();
        UserRole userRole = new UserRole();

        AppUser appUser = employee.getAppUser();
        appUser.setCreationDate(Date.valueOf(LocalDate.now()));
        appUser.setPassword("123456");
        this.iAppUserService.saveAppUser(appUser);

        appRole.setId(2);
        userRole.setAppRole(appRole);

        AppUser au = this.iAppUserService.findAppUserByUserName(appUser.getUserName());

        userRole.setAppUser(au);
        userRole.setIsDeleted(false);

        this.iUserRoleService.save(userRole);
        employee.setAppUser(au);

        iEmployeeRepository.saveEmployee(employee);
    }

    /**
     * @creator TaiLV
     * Date 09/08/2022
     * @param id
     * if id null : Bad request
     * @return  object Employee
     */
    @Override
    public Employee findById(Integer id) {
        return iEmployeeRepository.findByIdEmployee(id);
    }

    /**
     * @creator TaiLV
     * Date 09/08/2022
     * @param employee
     * if employee null : Create new employee
     * @return  true: edit employee success, status 200 / false: status 404
     */

    @Override
    public void editEmployee(Employee employee) {
         iEmployeeRepository.editEmployee(employee);
    }




}
