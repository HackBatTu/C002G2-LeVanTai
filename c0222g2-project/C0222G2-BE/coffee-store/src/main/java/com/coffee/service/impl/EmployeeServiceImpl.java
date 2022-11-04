package com.coffee.service.impl;

import com.coffee.dto.IEmployeeDTO;
import com.coffee.model.account.AppRole;
import com.coffee.model.account.AppUser;
import com.coffee.model.account.UserRole;
import com.coffee.model.employee.Employee;
import com.coffee.repository.IEmployeeRepository;
import com.coffee.service.IAppUserService;
import com.coffee.service.IEmployeeService;
import com.coffee.service.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;


@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    @Autowired
    private IAppUserService iAppUserService;

    @Autowired
    private IUserRoleService iUserRoleService;


    /**
     * Create by TuyenTN
     * Date: 9-8-2022 16:37
     *
     * @param pageable
     * @param searchByName
     * @param searchByPhone
     * @param searchByAccount
     * @return
     */
    @Override
    public Page<IEmployeeDTO> getAllEmployee(Pageable pageable, String searchByName, String searchByPhone, String searchByAccount)
    {
        return iEmployeeRepository.getAllEmployee(pageable, "%" + searchByName + "%", "%" + searchByPhone + "%",
                "%" + searchByAccount + "%");
    }

    /**
     * Create by TuyenTN
     * Date: 9-8-2022
     * findEmployeeById(id)
     * @param id
     * @return
     */
    @Override
    public IEmployeeDTO findEmployeeById(Integer id) {
        return this.iEmployeeRepository.findEmployeeById(id);
    }

    /**
     * Create by TuyenTN
     * Date: 9-8-2022
     * deleteEmployeeById()
     * @param id
     */
    @Override
    public void deleteEmployeeById(Integer id) {
        this.iEmployeeRepository.deleteEmployeeById(id);
    }

    /**
     * end code TuyenTN
     */

//-------------------------------------------------------------------------------------------------------------------
    /**
     * start code TaiLV
     */

    /**
     * @param employee if employee null : Create new employee
     * @return true: create employee success, status 200 / false: status 404
     * @return create Employee success
     * @creator TaiLV
     * Date 09/08/2022
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
     * @param id if id null : Bad request
     * @return object Employee
     * @creator TaiLV
     * Date 09/08/2022
     */
    @Override
    public Employee findById(Integer id) {
        return iEmployeeRepository.findByIdEmployee(id);
    }

    /**
     * @param employee if employee null : Create new employee
     * @return true: edit employee success, status 200 / false: status 404
     * @creator TaiLV
     * Date 09/08/2022
     */
    @Override
    public void editEmployee(Employee employee) {
        iEmployeeRepository.editEmployee(employee);
    }

    @Override
    public List<Employee> findAll() {
        return this.iEmployeeRepository.findAllEmployee();
    }


}
