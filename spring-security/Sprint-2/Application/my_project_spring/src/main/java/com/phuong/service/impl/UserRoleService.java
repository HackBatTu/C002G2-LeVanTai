package com.phuong.service.impl;

import com.phuong.model.account.UserRole;
import com.phuong.repository.IUserRoleRepository;
import com.phuong.service.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService implements IUserRoleService {

    @Autowired
    private IUserRoleRepository userRoleRepository;

    @Override
    public void save(UserRole userRole) {
        this.userRoleRepository.save(userRole);
    }
}
