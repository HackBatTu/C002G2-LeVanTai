package com.phuong.service;

import com.phuong.dto.RegisterRequest;
import com.phuong.model.account.AppUser;

import java.util.List;

public interface IAppUserService {

    AppUser findAppUserByUsername(String username);

    void save(AppUser appUser);

    void registerUser(RegisterRequest registerRequest);

    List<AppUser> findAll();
}
