package com.link.service;

import com.link.model.User;
import com.link.reponsitory.IUserRepository;
import com.link.service.impl.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;


    @Override
    public List<User> getAllUser() {
        return iUserRepository.findAll();
    }
}
