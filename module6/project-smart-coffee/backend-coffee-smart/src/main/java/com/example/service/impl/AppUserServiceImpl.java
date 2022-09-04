package com.example.service.impl;

import com.example.model.AppUser;
import com.example.repository.IAppUserRepository;
import com.example.service.IAppUserService;
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
}
