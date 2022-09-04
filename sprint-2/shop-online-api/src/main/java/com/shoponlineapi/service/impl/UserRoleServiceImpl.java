package com.shoponlineapi.service.impl;

import com.shoponlineapi.model.account.UserRole;
import com.shoponlineapi.repository.IUserRoleRepository;
import com.shoponlineapi.service.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements IUserRoleService {
    @Autowired
    private IUserRoleRepository iUserRoleRepository;

    @Override
    public void save(UserRole userRole) {
        iUserRoleRepository.save(userRole);
    }
}
