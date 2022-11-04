package com.phuong.service.impl;

import com.phuong.dto.RegisterRequest;
import com.phuong.model.account.AppRole;
import com.phuong.model.account.UserRole;
import com.phuong.repository.IAppUserRepository;
import com.phuong.model.account.AppUser;
import com.phuong.service.IAppUserService;
import com.phuong.service.IUserRoleService;
import com.phuong.util.EncrytedPasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserService implements IAppUserService {

    @Autowired
    private IAppUserRepository IAppUserRepository;

    @Autowired
    private EncrytedPasswordUtils encrytedPasswordUtils;

    @Autowired
    private IUserRoleService userRoleService;

    @Override
    public AppUser findAppUserByUsername(String username) {
        return this.IAppUserRepository.getAppUserByUsername(username);
    }

    @Override
    public void save(AppUser appUser) {
        this.IAppUserRepository.save(appUser);
    }

    @Override
    public void registerUser(RegisterRequest registerRequest) {
        AppUser appUser = new AppUser();
        appUser.setUserName(registerRequest.getUsername());
        appUser.setPassword(this.encrytedPasswordUtils.encrytePassword(registerRequest.getPassword()));
        appUser.setIsDeleted(false);
        appUser.setStatus(false);
        AppUser appUserDone = this.IAppUserRepository.save(appUser);
        AppRole appRole = new AppRole();
        appRole.setId(2);
        UserRole userRole = new UserRole();
        userRole.setAppRole(appRole);
        userRole.setAppUser(appUserDone);
        userRole.setIsDeleted(false);
        this.userRoleService.save(userRole);
    }

    @Override
    public List<AppUser> findAll() {
        return this.IAppUserRepository.findAll();
    }
}
