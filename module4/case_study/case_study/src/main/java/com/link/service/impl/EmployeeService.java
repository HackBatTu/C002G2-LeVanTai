package com.link.service.impl;

import com.link.model.*;
import com.link.repository.*;
import com.link.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private IEmployeeRepository iEmployeeRepository;
    @Autowired
    private IEducationDegreeRepository iEducationDegreeRepository;
    @Autowired
    private IPositionRepository iPositionRepository;
    @Autowired
    private IDivisionRepository iDivisionRepository;
    @Autowired
    private IAppUserRepository iAppUserRepository;

    @Override
    public Page<Employee> findAllEmployee(String nameSearch, Pageable pageable) {
        return iEmployeeRepository.findAllEmployee("%"+nameSearch+"%",pageable);
    }

    @Override
    public void save(Employee employee) {
        iEmployeeRepository.save(employee);
    }

    @Override
    public List<Position> findAllPosition() {
        return iPositionRepository.findAll();
    }

    @Override
    public List<EducationDegree> findAllEducationDegreeList() {
        return iEducationDegreeRepository.findAll();
    }

    @Override
    public List<Division> findAllDivisionList() {
        return iDivisionRepository.findAll();
    }

    @Override
    public List<AppUser> findAllUser() {
        return iAppUserRepository.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        return iEmployeeRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteEmployee(Integer id) {
        iEmployeeRepository.deleteEmployee(id);
    }
}
