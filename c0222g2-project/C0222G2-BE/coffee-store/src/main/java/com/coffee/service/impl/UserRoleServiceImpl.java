package com.coffee.service.impl;

import com.coffee.model.account.UserRole;
import com.coffee.repository.account.IUserRoleRepository;
import com.coffee.service.IUserRoleService;
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
