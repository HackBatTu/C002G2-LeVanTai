package com.coffee.service.account.impl;

import com.coffee.model.account.AppUser;
import com.coffee.repository.IAppUserRepository;
import com.coffee.service.account.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserService implements IAppUserService {

    @Autowired
    private IAppUserRepository IAppUserRepository;

    /**
     *
     * @Creator PhuongTD
     * @date-create 9/8/2022
     * @param username
     * @return
     */
    @Override
    public AppUser findAppUserByUsername(String username) {
        return this.IAppUserRepository.findAppUserByUserName(username);
    }

    /**
     * @creator: PhuongTD
     * @date-create 9/8/2022
     * @param appUser
     */
    @Override
    public void updatePassword(AppUser appUser) {
        this.IAppUserRepository.updatePassword(appUser);
    }
}
