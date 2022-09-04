package com.shoponlineapi.service.impl;


import com.shoponlineapi.model.account.AppUser;
import com.shoponlineapi.repository.IAppUserRepository;
import com.shoponlineapi.service.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserServiceImpl implements IAppUserService {
    @Autowired
    private IAppUserRepository iUserRepository;

    /**
     * @creator TaiLV
     * Date 09/08/2022
     * @param
     * @return  AppUser list
     */
    @Override
    public List<AppUser> getAllUser() {
        return iUserRepository.findAllUser();
    }

    @Override
    public AppUser findAppUserByUserName(String userName) {
        return iUserRepository.findAppUserByUserName(userName);
    }

    @Override
    public void saveAppUser(AppUser appUser) {
        iUserRepository.saveAppUser(appUser);
    }

    /**
     * @creator: PhuongTD
     * @date-create 9/8/2022
     * @param appUser
     */
    @Override
    public void updatePassword(AppUser appUser) {
        this.iUserRepository.updatePassword(appUser);
    }
}
