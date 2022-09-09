package com.shoponlineapi.service;



import com.shoponlineapi.dto.RegisterDTO;
import com.shoponlineapi.model.account.AppUser;

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
    void updatePassword(AppUser appUser);

    void saveAppUser(AppUser appUser);

    void registerUser(RegisterDTO registerDTO);

}
