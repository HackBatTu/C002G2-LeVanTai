package com.coffee.service;



import com.coffee.model.account.AppUser;

import java.util.List;

public interface IAppUserService {
    /**
     * @creator TaiLV
     * Date 09/08/2022
     * @param
     * @return  AppUser list
     */
    List<AppUser> getAllUser();

    AppUser findAppUserByUserName(String userName);

    void saveAppUser(AppUser appUser);
}
