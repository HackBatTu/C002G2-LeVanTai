package com.coffee.service.account;

import com.coffee.model.account.AppUser;

public interface IAppUserService {

    AppUser findAppUserByUsername(String username);

    void updatePassword(AppUser appUser);
}
